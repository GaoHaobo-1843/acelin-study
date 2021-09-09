package com.gaohb.hello.study.springTest.amqp.rabbitmq;


import com.gaohb.hello.study.config.base.Base;
import com.gaohb.hello.study.config.rabbitmq.DirectRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DirectConsumers extends Base {

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_QUEUE_ONE)
    public void consumer1(Object testMessage) {
        logger.debug("Direct消费者[1]收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_QUEUE_TWO)
    public void consumer2(Object testMessage) {
        logger.debug("Direct消费者[2]收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_QUEUE_THREE)
    public void consumer3(Object testMessage) {
        logger.debug("Direct消费者[3]收到消息  : " + testMessage.toString());
    }


}
