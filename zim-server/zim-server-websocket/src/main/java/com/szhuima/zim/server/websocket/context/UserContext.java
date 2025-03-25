package com.szhuima.zim.server.websocket.context;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 21:54
 * * @Description
 **/
public class UserContext {

    private static Map<String, ChannelHandlerContext> CHANNEL_MAP = new ConcurrentHashMap<>();

    public static void bindChannel(String userId, ChannelHandlerContext ctx) {
        CHANNEL_MAP.put(userId, ctx);
    }

    public static ChannelHandlerContext getChannel(String userId) {
        return CHANNEL_MAP.get(userId);
    }


}
