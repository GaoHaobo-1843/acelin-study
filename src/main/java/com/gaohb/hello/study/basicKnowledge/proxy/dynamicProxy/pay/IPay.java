package com.gaohb.hello.study.basicKnowledge.proxy.dynamicProxy.pay;

public interface IPay {

    boolean check(Integer balance,Integer owe);

    void writeOffCheck();

    void openCheck();

    void start();

}
