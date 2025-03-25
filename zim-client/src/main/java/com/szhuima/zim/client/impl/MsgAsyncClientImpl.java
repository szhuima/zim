package com.szhuima.zim.client.impl;

import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.proto.msg.MsgServiceGrpc;
import com.szhuima.zim.client.MsgAsyncClient;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 01:10
 * * @Description
 **/
@Component
public class MsgAsyncClientImpl implements MsgAsyncClient {


    @GrpcClient(value = "grpc-server")
    private MsgServiceGrpc.MsgServiceStub messageService;


    /**
     * 发送消息
     *
     * @param msgRequest
     */
    @Override
    public void sendMsgAsync(MsgProto.MsgRequest msgRequest, StreamObserver<MsgProto.MsgResponse> responseObserver) {
        messageService.sendMsgAsync(msgRequest, responseObserver);
    }
}
