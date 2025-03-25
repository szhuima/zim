package com.szhuima.zim.api.domain.msg;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 23:16
 * * @Description
 **/
public enum MsgStatus {

    /**
     * 消息已送达
     */
    RECEIVED,

    /**
     * 消息已读
     */
    READ,

    /**
     * 消息撤回
     */
    RECALLED,

    /**
     * 消息发送失败
     */
    SENT_FAIL;


}
