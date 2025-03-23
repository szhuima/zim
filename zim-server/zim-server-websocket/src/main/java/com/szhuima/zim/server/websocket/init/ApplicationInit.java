package com.szhuima.zim.server.websocket.init;

import com.szhuima.zim.server.api.ZimServer;
import com.szhuima.zim.server.websocket.server.WebsocketServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 22:44
 * * @Description
 **/
@Component
public class ApplicationInit implements ApplicationRunner {

    @Value("${websocket.port}")
    private int port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 启动ZimServer
        ZimServer server = new WebsocketServer();
        server.start(port);


    }
}
