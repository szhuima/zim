package com.szhuima.zim.client.example.controller;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.client.MsgAsyncClient;
import com.szhuima.zim.client.MsgSyncClient;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 23:37
 * * @Description
 **/
@Slf4j
@RequestMapping("/")
@RestController
public class HelloMsgController {

    @Value("${grpc.client.grpc-server.address}")
    private String grpcServerAddress;

    @Resource
    private MsgSyncClient msgClient;

    @Resource
    private MsgAsyncClient msgAsyncClient;




    @PostConstruct
    public void init() {
        System.out.println("grpcServerAddress = " + grpcServerAddress);
    }


    @PostMapping("/hello")
    public String hello() {
        MsgProto.MsgRequest msgRequest = MsgProto.MsgRequest.newBuilder()
                .setMsgId(1001L)
                .setContent("Hello World")
                .setFrom("100")
                .setTo("1")
                .setMsgType(MsgProto.MsgType.SINGLE)
                .setContentType(MsgProto.ContentType.TEXT)
                .build();
        MsgProto.MsgResponse msgResponse = msgClient.sendMsg(msgRequest);
        return msgResponse.toString();
    }

    @PostMapping("/hello2")
    public String hello2() {
        MsgProto.MsgRequest msgRequest = MsgProto.MsgRequest.newBuilder()
                .setMsgId(1001L)
                .setContent("Hello World Async")
                .setFrom("100")
                .setTo("1")
                .setMsgType(MsgProto.MsgType.SINGLE)
                .setContentType(MsgProto.ContentType.TEXT)
                .build();


        StreamObserver<MsgProto.MsgResponse> responseStreamObserver = new StreamObserver<MsgProto.MsgResponse>() {

            @Override
            public void onNext(MsgProto.MsgResponse msgResponse) {
                long msgId = msgResponse.getMsgId();
                MsgProto.ResponseCode code = msgResponse.getCode();
                log.info("msgId = " + msgId + ", code = " + code);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };

        msgAsyncClient.sendMsg(msgRequest,responseStreamObserver);
        return "ok;";
    }

}
