package com.gaohb.hello.study.springTest.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author H
 * 2022/9/12 13:29
 */
@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    private final static String TOPIC_NAME = "acelin-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public String send() {
        kafkaTemplate.send(TOPIC_NAME, "key-1", "Hello Kafka!");
        return "success";
    }
}
