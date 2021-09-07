package com.gaohb.hello.study.springTest.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AspectControllerTest {

    @Autowired
    private IAspect aspect;

    @Test
    void testAop() {
        aspect.testAop("业务");
    }

    @Test
    void anotherTest() {
        aspect.anotherTest("业务2");

    }

    @Test
    void otherTest() {
    }
}