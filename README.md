# 简介 | Intro
Zim 一个基于gRPC和Netty的即时通讯基础组件

# 核心依赖及版本
- Java：8
- gRPC: 1.51.0
- Netty: 4.1.25.Final
- SpringBoot: 2.7.18

# 模块介绍
- zim-client：用于和IM服务端交互的客户端SDK。
- zim-server：IM服务端
  - zim-server-websocket: 基于websocket协议实现的IM服务端。
  - zim-server-tcp: 基于TCP协议实现的IM服务端。
- zim-api: proto buf 消息体定义和一些工具类。




