package com.gaohb.hello.study.basicKnowledge.singleton;

public class HungrySingleton {

    private static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getINSTANCE() {
        return INSTANCE;
    }
}
