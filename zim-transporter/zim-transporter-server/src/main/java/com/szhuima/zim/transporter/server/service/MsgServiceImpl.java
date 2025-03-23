package com.szhuima.zim.transporter.server.service;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.proto.msg.MsgServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 15:45
 * * @Description
 **/
public class MsgServiceImpl extends MsgServiceGrpc.MsgServiceImplBase {


    @Override
    public void sendMsg(MsgProto.MsgRequest request, StreamObserver<MsgProto.MsgResponse> responseObserver) {
        long msgId = request.getMsgId();

        MsgProto.MsgResponse.Builder builder = MsgProto.MsgResponse.newBuilder();
        builder.setMsgId(msgId);
        responseObserver.onNext(builder.build());

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
        long msgId = request.getMsgId();

        for (int i = 0; i < 10; i++) {
            MsgProto.MsgResponse.Builder builder = MsgProto.MsgResponse.newBuilder();
            builder.setMsgId(msgId);
            responseObserver.onNext(builder.build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        responseObserver.onCompleted();
    }
}
