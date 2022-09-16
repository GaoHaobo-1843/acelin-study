package com.gaohb.hello.study.basicKnowledge.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VolatileListCounter {
    public volatile static List<String> countList = new ArrayList<>();
    public static void count() {

        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            stringList.add(i+"");
        }

        synchronized(VolatileListCounter.class) {
            countList.addAll(stringList);
        }

    }



    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1000);

        //同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    VolatileListCounter.count();
                    latch.countDown();
                }
            }).start();
        }
        latch.await();

        System.out.println("运行结果:Counter.count=" + VolatileListCounter.countList.size());

    }
}
