package com.gaohb.hello.study.basicKnowledge.singleton;

public class StaticInnerClassSingleton {

    private static class SingletonInnerClass{
        private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getInstance(){
        return SingletonInnerClass.INSTANCE;
    }
}
