package com.szhuima.zim.transporter.client;


import com.szhuima.zim.api.domain.msg.ContentType;
import com.szhuima.zim.api.domain.msg.MsgType;
import com.szhuima.zim.api.domain.msg.ZimMsg;
import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.proto.msg.MsgServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 23:27
 * * @Description
 **/
public class TransporterClient {






    public static void main(String[] args) {
        MsgClient msgClient = new MsgClient("127.0.0.1", 9002);
        ZimMsg zimMsg = new ZimMsg();
        zimMsg.setMsgId(1L);
        zimMsg.setContent("hello");
        zimMsg.setMsgType(MsgType.SINGLE);
        zimMsg.setContentType(ContentType.TEXT);
        zimMsg.setTo("szhuima");
        zimMsg.setFrom("szhuima");
        zimMsg.setSendTime(System.currentTimeMillis());
        msgClient.sendMsg(zimMsg);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
