package com.szhuima.zim.client.example;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.client.MsgClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 23:17
 * * @Description
 **/
@SpringBootTest
public class MsgClientTest {

    @Resource
    private MsgClient msgClient;

    @Test
    public void test1() {
        MsgProto.MsgRequest msgRequest = MsgProto.MsgRequest.newBuilder()
                .setMsgId(1001L)
                .setContent("Hello World")
                .setFrom("100")
                .setTo("1")
                .setMsgType(MsgProto.MsgType.SINGLE)
                .setContentType(MsgProto.ContentType.TEXT)
                .build();
        MsgProto.MsgResponse msgResponse = msgClient.sendMsg(msgRequest);
        System.out.println(msgResponse);
    }
}
