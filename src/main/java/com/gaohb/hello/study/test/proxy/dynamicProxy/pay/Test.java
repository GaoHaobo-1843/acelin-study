package com.gaohb.hello.study.test.proxy.dynamicProxy.pay;

public class Test {

    public static void main(String[] args){

        SPayA payA = new SPayA();
        SPayB payB = new SPayB();
        IPay apay = PayFactory.getProxyInstance(payA);
        IPay bpay = PayFactory.getProxyInstance(payB);
        apay.start();
        bpay.start();
    }
}
