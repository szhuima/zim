package com.szhuima.zim.client.example.controller;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.client.MsgClient;
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
@RequestMapping("/")
@RestController
public class HelloMsgController {

    @Value("${grpc.client.grpc-server.address}")
    private String grpcServerAddress;

    @Resource
    private MsgClient msgClient;


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

}
