package com.gaohb.hello.study.springTest.mybatis;

import com.gaohb.hello.study.springTest.aop.IAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisTest {

    @Autowired
    private MybatisController mybatisController;

    @Test
    void testAop() {
        mybatisController.post();
    }


}