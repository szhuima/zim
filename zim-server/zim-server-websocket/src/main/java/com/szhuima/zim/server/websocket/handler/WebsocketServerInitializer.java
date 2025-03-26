package com.szhuima.zim.server.websocket.handler;

import com.szhuima.zim.server.websocket.handler.codec.MsgRequestEncoder;
import com.szhuima.zim.server.websocket.handler.codec.WebsocketDecoder;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 23:01
 * * @Description
 **/
public class WebsocketServerInitializer extends ChannelInitializer<SocketChannel> {


    private static final MsgRequestEncoder MSG_REQUEST_ENCODER = new MsgRequestEncoder();

    private static final WebsocketDecoder WEBSOCKET_DECODER = new WebsocketDecoder();

    private static final FilterInboundHandler FILTER_INBOUND_HANDLER = new FilterInboundHandler();



    /**
     * This method will be called once the {@link Channel} was registered. After the method returns this instance
     * will be removed from the {@link ChannelPipeline} of the {@link Channel}.
     *
     * @param ch the {@link Channel} which was registered.
     * @throws Exception is thrown if an error occurs. In that case it will be handled by
     *                   {@link #exceptionCaught(ChannelHandlerContext, Throwable)} which will by default close
     *                   the {@link Channel}.
     */
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpObjectAggregator(65535));
        pipeline.addLast(MSG_REQUEST_ENCODER);
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(WEBSOCKET_DECODER);
        pipeline.addLast(FILTER_INBOUND_HANDLER);
        pipeline.addLast(new InstructionInboundHandler());
    }
}
