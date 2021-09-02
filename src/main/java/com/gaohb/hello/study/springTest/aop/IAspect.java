package com.gaohb.hello.study.springTest.aop;

import org.springframework.web.bind.annotation.PathVariable;

public interface IAspect {


    void testAop(@PathVariable("businessName") String businessName);

    @ApiLog
    void anotherTest(@PathVariable("businessName") String businessName);


    void otherTest(@PathVariable("businessName") String businessName);
}
