package com.gaohb.hello.study.test.singleton;

public class LazySingleton {

    private volatile static LazySingleton INSTANCE; // volatile禁止指令重排

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
