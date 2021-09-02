package com.gaohb.hello.study.test.proxy.dynamicProxy.pay;

public class SPayA implements IPay{


    @Override
    public boolean check(Integer balance,Integer owe) {

        return balance >= owe;
    }

    @Override
    public void writeOffCheck() {
        System.out.println("冲销校验A");
    }

    @Override
    public void openCheck() {
        System.out.println("开机校验A");
    }

    @Override
    public void start() {

    }
}
