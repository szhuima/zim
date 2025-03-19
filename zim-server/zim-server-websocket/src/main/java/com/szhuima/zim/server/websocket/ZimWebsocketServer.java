package com.szhuima.zim.server.websocket;

import com.szhuima.zim.server.api.ZimServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 23:25
 * * @Description
 **/
public class ZimWebsocketServer implements ZimServer {

    private NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);

    private NioEventLoopGroup workerGroup = new NioEventLoopGroup();

    /**
     * 启动服务
     *
     * @param port 端口号
     */
    @Override
    public void start(Integer port) {
        new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ZimWebsocketServerInitializer())
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .bind(port);

    }

    /**
     * 停止服务
     */
    @Override
    public void stop() {

    }
}
