package com.gaohb.hello.study.test.proxy.dynamicProxy.pay;

public class SPayB implements IPay{


    @Override
    public boolean check(Integer balance,Integer owe) {
        return balance - owe > 0;
    }

    @Override
    public void writeOffCheck() {
        System.out.println("冲销校验B");
    }

    @Override
    public void openCheck() {
        System.out.println("开机校验B");
    }

    @Override
    public void start() {

    }
}
