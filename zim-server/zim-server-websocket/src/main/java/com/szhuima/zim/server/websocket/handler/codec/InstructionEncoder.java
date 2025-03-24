package com.szhuima.zim.server.websocket.handler.codec;

import com.alibaba.fastjson.JSON;
import com.szhuima.zim.api.proto.instruction.InstructionProto;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.List;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 21:15
 * * @Description
 **/
public class InstructionEncoder extends MessageToMessageEncoder<InstructionProto.Instruction> {

    /**
     * Encode from one message to an other. This method will be called for each written message that can be handled
     * by this encoder.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link MessageToMessageEncoder} belongs to
     * @param msg the message to encode to an other one
     * @param out the {@link List} into which the encoded msg should be added
     *            needs to do some kind of aggregation
     * @throws Exception is thrown if an error occurs
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, InstructionProto.Instruction msg, List<Object> out) throws Exception {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.toByteArray());
        BinaryWebSocketFrame binaryFrame = new BinaryWebSocketFrame(byteBuf);
        out.add(binaryFrame);
    }
}
