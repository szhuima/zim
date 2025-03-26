package com.szhuima.zim.server.websocket.handler;

import com.szhuima.zim.server.websocket.context.UserStatusContext;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.springframework.util.StringUtils;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 21:53
 * * @Description
 **/
@ChannelHandler.Sharable
public class FilterInboundHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 手动将消息传递给下一个处理器
        ctx.fireChannelRead(msg);
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            WebSocketServerProtocolHandler.HandshakeComplete handshakeComplete = (WebSocketServerProtocolHandler.HandshakeComplete) evt;
            HttpHeaders headers = handshakeComplete.requestHeaders();
            String userId = headers.get("user_id");
            if (StringUtils.hasText(userId)) {
                UserStatusContext.bindChannel(userId, ctx);
            }
        }
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        UserStatusContext.removeUser(ctx);
    }
}
