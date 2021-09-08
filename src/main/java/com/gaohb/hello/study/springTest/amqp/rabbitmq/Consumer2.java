package com.gaohb.hello.study.springTest.amqp.rabbitmq;


import com.gaohb.hello.study.config.rabbitmq.DirectRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = DirectRabbitConfig.DIRECT_QUEUE_TWO)
public class Consumer2 {

    @RabbitHandler
    public void process(Object testMessage) {
        System.out.println("消费者[2]收到消息  : " + testMessage.toString());
    }

}
