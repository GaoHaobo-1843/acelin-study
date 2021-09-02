package com.gaohb.hello.study.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter {
    public  static AtomicInteger count = new AtomicInteger(0);
    public static void inc() {

        /* 这里延迟1毫秒，使得结果明显 */
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {

        }
        count.getAndIncrement();
    }



    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1000);

        /* 同时启动1000个线程，去进行i++计算，看看实际结果 */
        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    AtomicIntegerCounter.inc();
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println("运行结果:Counter.count=" + AtomicIntegerCounter.count);
    }
}
