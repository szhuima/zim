package com.szhuima.zim.server.websocket;

import com.szhuima.zim.server.api.ZimServer;
import com.szhuima.zim.server.websocket.handler.WebsocketServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
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
                .channel(NioServerSocketChannel.class)
                .childHandler(new WebsocketServerInitializer())
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .bind(port);

        future.syncUninterruptibly();

        future.addListener((ChannelFutureListener) future1 -> logger.info("WebSocketServer.start|Port:：{}", port));

        future.channel().closeFuture().sync();
    }

    /**
     * 停止服务
     */
    @Override
    public void stop() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();

    }
}
