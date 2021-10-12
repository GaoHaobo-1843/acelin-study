package com.gaohb.hello.study.springTest.rabbitmq;

import com.gaohb.hello.study.config.base.Base;
import com.gaohb.hello.study.config.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class WorkConsumers extends Base {

    @RabbitListener(queues = RabbitConfig.WORK_QUEUE)
    public void consumer1(Object testMessage) {
        logger.debug("work消费者[1]收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = RabbitConfig.WORK_QUEUE)
    public void consumer2(Object testMessage) {
        logger.debug("work消费者[2]收到消息  : " + testMessage.toString());
    }
}
