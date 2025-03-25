package com.szhuima.zim.client;

import com.szhuima.zim.api.proto.msg.MsgProto;
import io.grpc.stub.StreamObserver;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 01:16
 * * @Description
 **/
public interface MsgAsyncClient {


    /**
     * 异步发送消息
     * @param msgRequest
     * @param responseObserver
     * @return
     */
    void sendMsgAsync(MsgProto.MsgRequest msgRequest, StreamObserver<MsgProto.MsgResponse> responseObserver);


}
