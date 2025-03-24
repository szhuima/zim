package com.szhuima.zim.server.websocket.handler;

import com.szhuima.zim.api.proto.instruction.InstructionProto;
import com.szhuima.zim.server.api.util.FlushMsgRetryTask;
import com.szhuima.zim.server.api.util.FlushMsgRetryUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 20:53
 * * @Description
 **/
@Slf4j
public class InstructionInboundHandler extends SimpleChannelInboundHandler<InstructionProto.Instruction> {


    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link I}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, InstructionProto.Instruction msg) throws Exception {
        InstructionProto.InstructionType type = msg.getType();
        switch (type) {
            case HEAR_BEAT:
                ctx.writeAndFlush(msg);
                break;
            case ACK:
                FlushMsgRetryUtil.cancelTask(msg.getMsgId());
                break;
            default:
                break;
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("netty exception caught", cause);
    }
}
