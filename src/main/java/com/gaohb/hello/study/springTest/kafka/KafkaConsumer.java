package com.gaohb.hello.study.springTest.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * @author H
 * 2022/9/12 13:44
 */
@Component
public class KafkaConsumer {


    /**
     * 可选入参
     * org.apache.kafka.clients.consumer.ConsumerRecord to access to the raw Kafka message
     * org.springframework.kafka.support.Acknowledgment to manually ack
     *
     * @Payload-annotated method arguments including the support of validation
     * @Header-annotated method arguments to extract a specific header value, defined by KafkaHeaders
     * @Headers-annotated argument that must also be assignable to java.util.Map for getting access to all headers.
     * MessageHeaders arguments for getting access to all headers.
     * MessageHeaderAccessor for convenient access to all method arguments.
     **/

    @KafkaListener(topics = "DEFAULT_TOPIC_1", groupId = "acelinGroup")
    public void listenGroup(ConsumerRecord<String, String> consumerRecord, Acknowledgment ack, MessageHeaders messageHeaders) {
        String value = consumerRecord.value();
        System.out.println(value);
//        System.out.println(consumerRecord);
        ack.acknowledge();
    }
}
