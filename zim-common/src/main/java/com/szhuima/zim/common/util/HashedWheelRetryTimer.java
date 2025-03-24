package com.szhuima.zim.common.util;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * * @Author: szhuima
 * * @Date    2025/3/24 17:44
 * * @Description
 **/
public class HashedWheelRetryTimer {

    private static final Logger log = LoggerFactory.getLogger(RetryTask.class);

    private Timer timer;

    public HashedWheelRetryTimer() {
        timer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
    }

    public HashedWheelRetryTimer(Timer timer) {
        this.timer = timer;
    }

    /**
     * @param task          任务
     * @param maxRetries    最大重试次数
     * @param retryInterval 重试间隔 单位：毫秒
     */
    public Timeout runTask(Runnable task, int maxRetries, long retryInterval) {
        RetryTask retryTask = new RetryTask(task, maxRetries, retryInterval, timer);
        Timeout timeout = timer.newTimeout(retryTask, 0, TimeUnit.MILLISECONDS);
        return timeout;
    }


    static class RetryTask implements TimerTask {

        private final Runnable task;
        private int remainingRetries;
        private final long retryInterval;
        private final Timer timer;

        public RetryTask(Runnable task, int maxRetries, long retryInterval, Timer timer) {
            this.task = task;
            this.remainingRetries = maxRetries;
            this.retryInterval = retryInterval;
            this.timer = timer;
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            try {
                // 执行任务
                task.run();
            } catch (Exception e) {
                if (remainingRetries > 0) {
                    // 重试次数减 1
                    remainingRetries--;
                    // 重新安排任务
                    timer.newTimeout(this, retryInterval, TimeUnit.MILLISECONDS);
                } else {
                    throw e;
                }
            }
        }

    }


}

