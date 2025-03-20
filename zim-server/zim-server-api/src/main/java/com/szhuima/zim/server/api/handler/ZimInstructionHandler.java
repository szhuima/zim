package com.szhuima.zim.server.api.handler;

import com.szhuima.zim.api.domain.instruction.ZimInstruction;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 23:31
 * * @Description
 **/
public class ZimInstructionHandler extends SimpleChannelInboundHandler<ZimInstruction> {

    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link I}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param instruction the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ZimInstruction instruction) throws Exception {

    }
}
