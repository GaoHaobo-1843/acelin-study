package com.gaohb.hello.study.test.proxy.dynamicProxy.cook;

import java.util.List;

public interface ICooking {

    List<String> preparing(); // 准备食材

    void flavouring(List<String> recipe); // 调味

    int cooking(); // 煮菜

    String serving(); // 装菜
}
