package com.szhuima.zim.server.api;

/**
 * * @Author: szhuima
 * * @Date    2025/3/19 22:53
 * * @Description
 **/
public interface ZimServer {

    /**
     * 启动服务
     * @param port 端口号
     */
    public void start(Integer port) throws InterruptedException;

    /**
     * 停止服务
     */
    void stop();
}
