package com.gaohb.hello.study.basicKnowledge.jvmTest;


public class JvmTest {

    public static void main(String[] args) {

        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms 初始堆内存为：" + initialMemory + "m" );
        System.out.println("-Xmx 最大堆内存为：" + maxMemory + "m" );

//        try{
//            Thread.sleep(1000000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }


    }
}
