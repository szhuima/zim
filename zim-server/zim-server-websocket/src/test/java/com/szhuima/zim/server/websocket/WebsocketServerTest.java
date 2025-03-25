package com.szhuima.zim.server.websocket;

import com.szhuima.zim.server.websocket.server.WebsocketServer;
import org.junit.Test;


public class WebsocketServerTest {

    @Test
    public void start() throws InterruptedException {
        WebsocketServer server = new WebsocketServer();
        server.start(8899);
    }

    @Test
    public void stop() {

    }
}