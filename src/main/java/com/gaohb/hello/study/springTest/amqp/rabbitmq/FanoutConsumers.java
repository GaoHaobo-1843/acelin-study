package com.gaohb.hello.study.springTest.amqp.rabbitmq;


import com.gaohb.hello.study.config.base.Base;
import com.gaohb.hello.study.config.rabbitmq.DirectRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutConsumers extends Base {

    @RabbitListener(queues = DirectRabbitConfig.FANOUT_QUEUE_ONE)
    public void consumer1(Object testMessage) {
        logger.debug("FANOUT消费者[1]收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = DirectRabbitConfig.FANOUT_QUEUE_TWO)
    public void consumer2(Object testMessage) {
        logger.debug("FANOUT消费者[2]收到消息  : " + testMessage.toString());
    }
}
