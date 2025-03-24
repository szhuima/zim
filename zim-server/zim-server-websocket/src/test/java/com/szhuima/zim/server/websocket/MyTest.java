package com.szhuima.zim.server.websocket;

import com.szhuima.zim.common.retry.HashedWheelRetryTimer;
import io.netty.util.HashedWheelTimer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * * @Author: szhuima
 * * @Date    2025/3/23 22:02
 * * @Description
 **/
@Slf4j
public class MyTest {


    @Test
    public void test1() throws InterruptedException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                System.out.println("timer = " + timer);
            }
        }, 2000, 1000);


        TimeUnit.SECONDS.sleep(100000);
    }


    @Test
    public void test2() throws InterruptedException {
        int res = 3 >> 1;
        System.out.println("res = " + res);
    }

    @Test
    public void test3() throws InterruptedException {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(1L, TimeUnit.SECONDS);
        HashedWheelRetryTimer hashedWheelRetryTimer = new HashedWheelRetryTimer(hashedWheelTimer);

        hashedWheelRetryTimer.runTask(() -> {
            log.info("任务被执行了...");
        }, 2, 2000);

        TimeUnit.SECONDS.sleep(20000);
    }


}
