package com.szhuima.zim.client.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 23:14
 * * @Description
 **/
@ComponentScan(basePackages = "com.szhuima.zim.client")
@SpringBootApplication
public class ClientExampleApp {



    public static void main(String[] args) {
        SpringApplication.run(ClientExampleApp.class, args);
    }

    // 打印grpcServerAddress


}
