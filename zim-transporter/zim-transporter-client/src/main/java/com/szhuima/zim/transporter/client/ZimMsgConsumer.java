package com.szhuima.zim.transporter.client;

import com.szhuima.zim.api.domain.msg.ZimMsg;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 15:59
 * * @Description
 **/
public interface ZimMsgConsumer {

    /**
     * 消费消息
     * @param zimMsg
     */
    void consumeMsg(ZimMsg zimMsg);

}
