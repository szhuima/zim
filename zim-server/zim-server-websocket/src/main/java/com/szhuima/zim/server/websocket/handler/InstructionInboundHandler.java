package com.szhuima.zim.server.websocket.handler;

import com.szhuima.zim.api.proto.instruction.InstructionProto;
import com.szhuima.zim.api.proto.msg.MsgProto;
import com.szhuima.zim.api.util.WrappedStreamObserver;
import com.szhuima.zim.server.api.util.FlushMsgRetryTask;
import com.szhuima.zim.server.api.util.FlushMsgRetryUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 20:53
 * * @Description
 **/
@Slf4j
public class InstructionInboundHandler extends SimpleChannelInboundHandler<InstructionProto.Instruction> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, InstructionProto.Instruction msg) throws Exception {
        InstructionProto.InstructionType type = msg.getType();
        switch (type) {
            case HEAR_BEAT:
                ctx.writeAndFlush(msg);
                break;
            case ACK:
                FlushMsgRetryUtil.cancelTask(msg.getMsgId());
                Attribute<WrappedStreamObserver<MsgProto.MsgResponse>> attr = ctx.channel().attr(AttributeKey.valueOf(String.valueOf(msg.getMsgId())));
                WrappedStreamObserver<MsgProto.MsgResponse> wrappedStreamObserver = attr.get();
                if (wrappedStreamObserver != null) {
                    MsgProto.MsgResponse response = MsgProto.MsgResponse.newBuilder().setCode(MsgProto.ResponseCode.ACKED).build();
                    wrappedStreamObserver.onNext(response);
                }
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
