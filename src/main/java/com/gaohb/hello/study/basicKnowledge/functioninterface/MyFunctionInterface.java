package com.gaohb.hello.study.basicKnowledge.functioninterface;

/**
 * @author H
 * 2022/10/20 15:17
 */
@FunctionalInterface
public interface MyFunctionInterface {

    void run();

    default String hello() {
        return "hello!";
    }

    @Override
    String toString();
}
