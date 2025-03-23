package com.szhuima.zim.transporter.server;

import com.szhuima.zim.api.IServer;
import com.szhuima.zim.transporter.server.service.MsgServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * * @Author: szhuima
 * * @Date    2025/3/20 23:15
 * * @Description
 **/
public class TransporterServer implements IServer {

    private Integer port;

    ServerBuilder<?> serverBuilder;

    public TransporterServer(Integer port) {
        this.port = port;
        serverBuilder = ServerBuilder.forPort(port);
    }

    @Override
    public void start() throws Exception {
        serverBuilder.addService(new MsgServiceImpl());
        Server server = serverBuilder.build();
        server.start();
        server.awaitTermination();
    }

    @Override
    public void stop() throws Exception {

    }


    public static void main(String[] args) throws Exception {
        TransporterServer transporterServer = new TransporterServer(9002);
        transporterServer.start();
    }
}
