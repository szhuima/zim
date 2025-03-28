package com.szhuima.zim.client;

import com.szhuima.zim.api.proto.msg.MsgProto;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 16:02
 * * @Description
 **/
public interface MsgSyncClient {

    /**
     * 发送消息
     * @param
     */
    MsgProto.MsgResponse sendMsg(MsgProto.MsgRequest msgRequest);



}
