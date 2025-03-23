package com.szhuima.zim.server.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 21:20
 * * @Description
 **/
@SpringBootApplication
public class WebSocketServerApp {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketServer.class, args);
    }

}
