package com.gaohb.hello.study.springTest.rabbitmq;


import com.gaohb.hello.study.config.base.Base;
import com.gaohb.hello.study.config.rabbitmq.DirectRabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_QUEUE_ONE)
    public void consumer3(Object testMessage) {
        logger.debug("Direct消费者[3]收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_QUEUE_THREE)
    public void consumerAck(Channel channel, Message message) {
        try{
            logger.debug("Direct消费者[ACK]收到消息  : " + message.toString());

            int i = 1/0;
            /**
             * @param deliveryTag 该消息的index
             * @param multiple 是否批量一次性ack所有小于deliveryTag的消息
             */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

        }catch (Exception e){
            try{
                logger.error("消费失败");
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false); //ack返回false，并重新回到队列
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); //拒绝消息
            }catch (IOException ioe){
                logger.error(ioe.getMessage());
            }
            logger.error(e.getMessage());
        }


    }



}
