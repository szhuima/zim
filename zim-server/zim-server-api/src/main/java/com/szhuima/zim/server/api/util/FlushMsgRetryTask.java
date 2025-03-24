package com.szhuima.zim.server.api.util;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 19:06
 * * @Description
 **/
public class FlushMsgRetryTask implements TimerTask {

    private final Timer timer;

    private ChannelHandlerContext ctx;

    private Long msgId;

    private Object msg;

    private int execCount = 0;

    // 总的尝试次数
    private static final int MAX_EXECUTION_COUNT = 3;

    public static final long DELAY = 3000;

    public FlushMsgRetryTask(ChannelHandlerContext ctx, Object msg,Timer timer) {
        this.ctx = ctx;
        this.msg = msg;
        this.timer = timer;
    }

    /**
     * Executed after the delay specified with
     * {@link Timer#newTimeout(TimerTask, long, TimeUnit)}.
     *
     * @param timeout a handle which is associated with this task
     */
    @Override
    public void run(Timeout timeout) throws Exception {
        ctx.writeAndFlush(msg);
        execCount++;
        if (execCount < MAX_EXECUTION_COUNT) {
            timer.newTimeout(this, DELAY,TimeUnit.MILLISECONDS);
        }
    }
}
