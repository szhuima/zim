package com.szhuima.zim.server.websocket.handler.codec;

import com.szhuima.zim.api.proto.msg.MsgProto;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

import java.util.List;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 00:34
 * * @Description
 **/
public class MsgRequestEncoder extends MessageToMessageEncoder<MsgProto.MsgRequest> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MsgProto.MsgRequest msg, List<Object> out) throws Exception {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.toByteArray());
        BinaryWebSocketFrame binaryFrame = new BinaryWebSocketFrame(byteBuf);
        out.add(binaryFrame);
    }
}
