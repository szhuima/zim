package com.szhuima.zim.server.websocket.handler;

import com.alibaba.fastjson2.JSON;
import com.szhuima.zim.api.proto.msg.MsgProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.List;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 00:34
 * * @Description
 **/
public class MsgRequestEncoder extends MessageToMessageEncoder<MsgProto.MsgRequest> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MsgProto.MsgRequest msg, List<Object> out) throws Exception {
        String msgStr = JSON.toJSONString(msg);
        out.add(new TextWebSocketFrame(msgStr));
    }
}
