package com.szhuima.zim.transporter.server;

import com.szhuima.zim.api.domain.msg.ZimMsg;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 15:45
 * * @Description
 **/
public interface ZimMsgProvider {

    /**
     * 发送消息
     * @param zimMsg
     */
    void sendMsg(ZimMsg zimMsg);

}
