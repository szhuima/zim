package com.szhuima.zim.server.websocket.service;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.proto.msg.MsgServiceGrpc;
import com.szhuima.zim.server.websocket.context.UserContext;
import io.grpc.stub.StreamObserver;
import io.netty.channel.ChannelHandlerContext;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 21:23
 * * @Description
 **/
@GrpcService
public class MsgServiceImpl extends MsgServiceGrpc.MsgServiceImplBase {


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
        ChannelHandlerContext channelHandlerContext = UserContext.getChannel(requestTo);
        if (channelHandlerContext == null) {
            responseBuilder.setCode(MsgProto.ResponseCode.NO_CONNECTION);
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
            return;
        }
        channelHandlerContext.writeAndFlush(request);

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
     * @param responseObserver
     */
    @Override
    public void sendMsgAsync(MsgProto.MsgRequest request, StreamObserver<MsgProto.MsgResponse> responseObserver) {
        super.sendMsgAsync(request, responseObserver);
    }
}
