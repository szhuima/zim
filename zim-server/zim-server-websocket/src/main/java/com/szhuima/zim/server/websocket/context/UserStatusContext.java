package com.szhuima.zim.server.websocket.context;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户状态上下文
 * * @Author: szhuima
 * * @Date    2025/3/23 21:54
 * * @Description
 **/
public class UserStatusContext {

    private static final Map<String, ChannelHandlerContext> CHANNEL_MAP = new ConcurrentHashMap<>();

    private static final String USER_ID = "userId";

    public static void bindChannel(String userId, ChannelHandlerContext ctx) {
        CHANNEL_MAP.put(userId, ctx);
        // 绑定用户到channel的属性
        AttributeKey<String> userKey = AttributeKey.valueOf(USER_ID);
        ctx.channel().attr(userKey).set(userId);
    }

    public static ChannelHandlerContext getChannel(String userId) {
        return CHANNEL_MAP.get(userId);
    }

    public static boolean containsChannel(String userId) {
        return CHANNEL_MAP.containsKey(userId);
    }

    public static void removeUser(ChannelHandlerContext ctx) {
        AttributeKey<String> userKey = AttributeKey.valueOf(USER_ID);
        String userId = ctx.channel().attr(userKey).get();
        if (userId != null) {
            CHANNEL_MAP.remove(userId);
            ctx.channel().attr(userKey).set(null);
        }
    }


}
