package com.gaohb.hello.study.test.proxy.dynamicProxy.pay;

public interface IPay {

    boolean check(Integer balance,Integer owe);

    void writeOffCheck();

    void openCheck();

    void start();

}
