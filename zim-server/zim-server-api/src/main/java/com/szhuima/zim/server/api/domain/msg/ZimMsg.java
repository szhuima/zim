package com.szhuima.zim.server.api.domain.msg;

import java.util.Date;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 23:08
 * * @Description
 **/

public class ZimMsg {

    private Long msgId;

    private MsgType msgType;

    private String content;

    private MsgContentType contentType;

    private MsgStatus status;

    private String msgFrom;

    private String msgTo;

    private Date sendTime;


    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MsgContentType getContentType() {
        return contentType;
    }

    public void setContentType(MsgContentType contentType) {
        this.contentType = contentType;
    }

    public MsgStatus getStatus() {
        return status;
    }

    public void setStatus(MsgStatus status) {
        this.status = status;
    }

    public String getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public String getMsgTo() {
        return msgTo;
    }

    public void setMsgTo(String msgTo) {
        this.msgTo = msgTo;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
