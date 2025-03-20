package com.szhuima.zim.client;

import com.szhuima.zim.api.domain.msg.ZimMsg;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 16:02
 * * @Description
 **/
public interface ZimMsgClient {

    /**
     * 发送消息
     * @param zimMsg
     */
    void sendMsg(ZimMsg zimMsg);


}
