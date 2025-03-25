package com.szhuima.zim.server.websocket.util;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 18:49
 * * @Description
 **/
public class FlushMsgRetryer {

    private static Timer timer = new HashedWheelTimer();

    private static Map<Long, Timeout> timeoutMap = new HashMap<>();


    public void flushMsg(Long msgId, Object msg, ChannelHandlerContext ctx) {
        ctx.writeAndFlush(msg);

        Timeout timeout = timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                ctx.writeAndFlush(msg);
            }
        }, 3, TimeUnit.SECONDS);
        timeoutMap.put(msgId, timeout);
    }


}
