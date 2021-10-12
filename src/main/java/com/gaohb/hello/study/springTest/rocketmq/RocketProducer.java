package com.gaohb.hello.study.springTest.rocketmq;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/rocket-producer")
public class RocketProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("/narmal/{msg}")
    public String pushMsg(@PathVariable("msg") String msg){

        rocketMQTemplate.convertAndSend("first-topic",msg);
        return "OK";
    }
}
