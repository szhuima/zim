package com.szhuima.zim.server.api.util;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 19:19
 * * @Description
 **/
public class FlushMsgRetryUtil {

    private static final Timer timer = new HashedWheelTimer();

    private static Map<Long, Timeout> timeoutMap = new ConcurrentHashMap<>();

    public static void flushMsg(ChannelHandlerContext ctx, Long msgId, Object msg) {
        FlushMsgRetryTask flushMsgRetryTask = new FlushMsgRetryTask(ctx, msg, timer);
        Timeout timeout = timer.newTimeout(flushMsgRetryTask, 0, TimeUnit.MILLISECONDS);
        timeoutMap.put(msgId, timeout);
    }

    public static boolean cancelTask(Long msgId) {
        Timeout timeout = timeoutMap.get(msgId);
        if (timeout != null) {
            timeout.cancel();
        }
        return true;
    }
}
