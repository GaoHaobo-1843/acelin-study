package com.gaohb.hello.study.test.proxy.dynamicProxy.pay;

import java.lang.reflect.Proxy;

public class PayFactory {

    public static IPay getProxyInstance(Object obj) {//obj:被代理类对象

        PayComponent payComponent = new PayComponent(obj);
        //返回一个代理类对象  Object是一个代理类的对象
        return (IPay) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),payComponent );

    }
}
