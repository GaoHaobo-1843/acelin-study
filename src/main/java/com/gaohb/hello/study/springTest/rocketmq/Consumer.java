package com.gaohb.hello.study.springTest.rocketmq;

import com.gaohb.hello.study.config.base.Base;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
//@RocketMQMessageListener(topic = "first-topic",consumerGroup = "producer-group")
public class Consumer extends Base implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        logger.info(msg);
    }


}
