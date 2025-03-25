package com.szhuima.zim.server.websocket.service;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.proto.msg.MsgServiceGrpc;
import com.szhuima.zim.api.util.WrappedStreamObserver;
import com.szhuima.zim.server.api.util.FlushMsgRetryUtil;
import com.szhuima.zim.server.websocket.context.UserContext;
import io.grpc.stub.StreamObserver;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.*;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.concurrent.TimeUnit;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 21:23
 * * @Description
 **/
@GrpcService
public class MsgServiceImpl extends MsgServiceGrpc.MsgServiceImplBase {

    private final Timer timer = new HashedWheelTimer(3, TimeUnit.SECONDS);


    /**
     * <pre>
     * 阻塞发送消息
     * </pre>
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void sendMsg(MsgProto.MsgRequest request, StreamObserver<MsgProto.MsgResponse> responseObserver) {
        MsgProto.MsgResponse.Builder responseBuilder = MsgProto.MsgResponse.newBuilder();

        String requestTo = request.getTo();
        ChannelHandlerContext ctx = UserContext.getChannel(requestTo);
        if (ctx == null) {
            responseBuilder.setCode(MsgProto.ResponseCode.NO_CONNECTION);
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
            return;
        }
        FlushMsgRetryUtil.flushMsg(ctx, request.getMsgId(), request);
        MsgProto.MsgResponse response = responseBuilder
                .setMsgId(request.getMsgId())
                .setCode(MsgProto.ResponseCode.FLUSHED)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * <pre>
     * 异步发送消息
     * </pre>
     *
     * @param request
     * @param responseObserver: 客户端传入，每次请求都是不一样的
     */
    @Override
    public void sendMsgAsync(MsgProto.MsgRequest request, StreamObserver<MsgProto.MsgResponse> responseObserver) {
        MsgProto.MsgResponse.Builder responseBuilder = MsgProto.MsgResponse.newBuilder();

        WrappedStreamObserver<MsgProto.MsgResponse> wrappedObserver = new WrappedStreamObserver<>(responseObserver);

        String requestTo = request.getTo();
        ChannelHandlerContext ctx = UserContext.getChannel(requestTo);
        if (ctx == null) {
            responseBuilder.setCode(MsgProto.ResponseCode.NO_CONNECTION);
            wrappedObserver.onNext(responseBuilder.build());
            wrappedObserver.onCompleted();
            return;
        }
        // 发送消息
        FlushMsgRetryUtil.flushMsg(ctx, request.getMsgId(), request);

        MsgProto.MsgResponse response = responseBuilder
                .setMsgId(request.getMsgId())
                .setCode(MsgProto.ResponseCode.FLUSHED)
                .build();
        wrappedObserver.onNext(response);

        AttributeKey<Object> seqAttrKey = AttributeKey.valueOf(String.valueOf(request.getMsgId()));
        ctx.channel().attr(seqAttrKey).set(wrappedObserver);
        // 预留3秒中等待ACK消息回复
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                wrappedObserver.onCompleted();
                // 清理channel attr,这里没法删除AttrKey,只能删除value。
                ctx.channel().attr(seqAttrKey).set(null);
            }
        };
        timer.newTimeout(timerTask, 3, TimeUnit.SECONDS);
    }
}
