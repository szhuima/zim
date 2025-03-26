package com.szhuima.zim.server.websocket.server;

import com.szhuima.zim.server.api.ZimServer;
import com.szhuima.zim.server.websocket.handler.WebsocketServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 23:25
 * * @Description
 **/
public class WebsocketServer implements ZimServer {

    private static Logger logger = LoggerFactory.getLogger(WebsocketServer.class);

    private NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);

    private NioEventLoopGroup workerGroup = new NioEventLoopGroup();

    /**
     * 启动服务
     *
     * @param port 端口号
     */
    @Override
    public void start(Integer port) throws InterruptedException {
        ChannelFuture future = new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .option(ChannelOption.SO_BACKLOG, 256) //设置服务器接受连接的队列长度
                .option(ChannelOption.SO_REUSEADDR, true) //可以复用之前处于TIME_WAIT状态的连接
                .option(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator.DEFAULT) // ByteBuf 的分配器
                .channel(NioServerSocketChannel.class)
                .childHandler(new WebsocketServerInitializer())
                .childOption(ChannelOption.SO_KEEPALIVE, true) // 开启 TCP 的保活机制，一般是两个小时发送探测包
                .childOption(ChannelOption.TCP_NODELAY, true) // 禁用 Nagle 算法
                .childOption(ChannelOption.RCVBUF_ALLOCATOR,new AdaptiveRecvByteBufAllocator()) // 可以动态调整接收缓冲区大小
                .bind(port);

        future.syncUninterruptibly();

        future.addListener((ChannelFutureListener) future1 -> logger.info("WebSocket Server started,listening on port:：{}", port));

        future.channel().closeFuture().sync();
    }

    /**
     * 停止服务
     */
    @Override
    public void stop() {
        if (!bossGroup.isShutdown()) {
            bossGroup.shutdownGracefully();
        }
        if (!workerGroup.isShutdown()) {
            workerGroup.shutdownGracefully();
        }
    }
}
