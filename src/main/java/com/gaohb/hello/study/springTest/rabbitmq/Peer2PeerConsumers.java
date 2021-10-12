package com.gaohb.hello.study.springTest.rabbitmq;

import com.gaohb.hello.study.config.base.Base;
import com.gaohb.hello.study.config.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class Peer2PeerConsumers extends Base {

    @RabbitListener(queues = RabbitConfig.PEER_TO_PEER_QUEUE)
    public void consumer2(Object testMessage) {
        logger.debug("peer-to-peer消费者收到消息  : " + testMessage.toString());
    }
}
