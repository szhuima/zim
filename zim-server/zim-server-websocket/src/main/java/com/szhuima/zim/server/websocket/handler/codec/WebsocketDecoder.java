package com.szhuima.zim.server.websocket.handler.codec;

import com.szhuima.zim.api.proto.msg.MsgProto;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.List;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 21:40
 * * @Description
 **/
@ChannelHandler.Sharable
public class WebsocketDecoder extends MessageToMessageDecoder<WebSocketFrame> {

    /**
     * Decode from one message to an other. This method will be called for each written message that can be handled
     * by this encoder.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link MessageToMessageDecoder} belongs to
     * @param msg the message to decode to an other one
     * @param out the {@link List} to which decoded messages should be added
     * @throws Exception is thrown if an error occurs
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, WebSocketFrame msg, List<Object> out) throws Exception {
        if (msg instanceof BinaryWebSocketFrame) {
            byte[] bytes = new byte[msg.content().readableBytes()];
            msg.content().readBytes(bytes);
            MsgProto.MsgRequest msgRequest = MsgProto.MsgRequest.parseFrom(bytes);
            out.add(msgRequest);
        }
    }
}
