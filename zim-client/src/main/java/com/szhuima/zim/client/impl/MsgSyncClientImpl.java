package com.szhuima.zim.client.impl;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.proto.msg.MsgServiceGrpc;
import com.szhuima.zim.client.MsgSyncClient;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 16:05
 * * @Description
 **/
@Component
public class MsgSyncClientImpl implements MsgSyncClient {

    @GrpcClient(value = "grpc-server")
    private MsgServiceGrpc.MsgServiceBlockingStub messageService;


    /**
     * 发送消息
     *
     * @param msg
     */
    @Override
    public MsgProto.MsgResponse sendMsg(MsgProto.MsgRequest msg) {
        MsgProto.MsgResponse msgResponse = messageService.sendMsg(msg);
        return msgResponse;
    }
}
