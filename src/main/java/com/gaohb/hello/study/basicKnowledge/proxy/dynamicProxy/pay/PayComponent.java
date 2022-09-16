package com.gaohb.hello.study.basicKnowledge.proxy.dynamicProxy.pay;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PayComponent implements InvocationHandler {

    public Object object;

    public PayComponent(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        if(methodName.equals("start")){

            System.out.println("缴费 ====> 开始");
            Method check = proxy.getClass().getMethod("check",Integer.class,Integer.class);
            Method writeOffCheck = proxy.getClass().getMethod("writeOffCheck");
            Method openCheck = proxy.getClass().getMethod("openCheck");

            boolean flag = (boolean) check.invoke(proxy,queryBalance(),queryOwe());
            if (flag){
                writeOffCheck.invoke(proxy);
                writeOff();
                openCheck.invoke(proxy);
                open();
            }

            System.out.println("缴费 ====> 结束");

        }else {
            return method.invoke(object,args);
        }
        return null;
    }

    public int queryBalance(){
        System.out.println("查余额");
        return 10;
    }

    public int queryOwe(){
        System.out.println("查欠费");
        return 8;
    }

    public void writeOff(){
        System.out.println("开始冲销");
    }

    public void open(){
        System.out.println("开始开机");
    }

}
