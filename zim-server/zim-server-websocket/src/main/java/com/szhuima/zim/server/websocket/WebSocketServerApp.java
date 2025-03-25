package com.szhuima.zim.server.websocket;

import com.szhuima.zim.server.websocket.server.WebsocketServer;
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
        SpringApplication.run(WebSocketServerApp.class, args);
    }

}
