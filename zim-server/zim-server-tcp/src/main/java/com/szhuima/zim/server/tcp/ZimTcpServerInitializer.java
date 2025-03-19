package com.szhuima.zim.server.tcp;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 23:01
 * * @Description
 **/
public class ZimTcpServerInitializer extends ChannelInitializer<SocketChannel> {


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
        pipeline.addLast();
    }
}
