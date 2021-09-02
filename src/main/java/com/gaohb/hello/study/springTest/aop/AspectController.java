package com.gaohb.hello.study.springTest.aop;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AspectController implements IAspect{

    @RequestMapping("/test/1/{businessName}")
    @ApiLog
    public void testAop(@PathVariable("businessName") String businessName){
        System.out.println("This is a controller about aop test!");
        if (businessName.length() > 4){
            throw new RuntimeException("业务名称太长！");
        }
    }

    @RequestMapping("/test/2/{businessName}")
    public void anotherTest(@PathVariable("businessName") String businessName){
        System.out.println("This is another controller about aop test!");
    }


    @RequestMapping("/test/3/{businessName}")
    public void otherTest(@PathVariable("businessName") String businessName){
        System.out.println("This is one controller about aop test!");
    }
}
