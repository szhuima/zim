package com.szhuima.zim.transporter.client;

import com.szhuima.zim.api.domain.msg.ZimMsg;
import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.proto.msg.MsgServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * * @Author: szhuima
 * * @Date    2025/3/21 12:23
 * * @Description
 **/
public class MsgClient {

    private String host;

    private Integer port;

    ManagedChannel channel;

    MsgServiceGrpc.MsgServiceStub msgService;


    public MsgClient(String host, Integer port) {
        this.host = host;
        this.port = port;
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        msgService = MsgServiceGrpc.newStub(channel);
    }


    public void sendMsg(ZimMsg zimMsg) {
        MsgProto.MsgRequest request = MsgProto.MsgRequest.newBuilder()
                .setMsgId(zimMsg.getMsgId())
                .setMsgType(MsgProto.MsgType.SINGLE)
                .setContent(zimMsg.getContent())
                .setContentType(MsgProto.ContentType.TEXT)
                .setStatus(MsgProto.MsgStatus.READ)
                .setFrom(zimMsg.getFrom())
                .setTo(zimMsg.getTo())
                .setSendTime(zimMsg.getSendTime())
                .build();
        msgService.sendMsgAsync(request, new StreamObserver<MsgProto.MsgResponse>() {
            @Override
            public void onNext(MsgProto.MsgResponse msgResponse) {
                long msgId = msgResponse.getMsgId();
                System.out.println("recv msgId = " + msgId);
                System.out.println(Thread.currentThread().getId());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
                System.out.println(Thread.currentThread().getId());
            }
        });

    }


}
