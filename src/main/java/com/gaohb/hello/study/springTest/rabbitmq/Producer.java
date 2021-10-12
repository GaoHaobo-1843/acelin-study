package com.gaohb.hello.study.springTest.rabbitmq;


import com.gaohb.hello.study.config.rabbitmq.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/producer")
public class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 【点对点模式】
     * @param task 消息内容
     **/
    @PostMapping("/peer-to-peer/{task}")
    public String peerToPeer(@PathVariable("task") String task){
        rabbitTemplate.convertAndSend(RabbitConfig.PEER_TO_PEER_QUEUE,task);
        return "ok";

    }


    /**
     * 【工作队列模式】
     * @param task 消息内容
     **/
    @PostMapping("/work/{task}")
    public String sendWorkMessage(@PathVariable("task") String task){

        rabbitTemplate.convertAndSend(RabbitConfig.WORK_QUEUE,task);
        return "ok";

    }

    /**
     * 【Direct路由模式】
     * @param message 消息内容
     **/
    @PostMapping("/direct/{message}")
    public String sendDirectMessage(@PathVariable("message") String message) {

        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message);

        /* 设置路由标识MY_ROUTING_KEY，发送到交换机MY_DIRECT_EXCHANGE */
        rabbitTemplate.convertAndSend(RabbitConfig.MY_DIRECT_EXCHANGE, RabbitConfig.ROUTING_KEY_ONE, map);
        return "ok";
    }

    /**
     * 【Fanout发布订阅模式】
     * @param message 消息内容
     **/
    @PostMapping("/fanout/{message}")
    public String sendFanoutMessage(@PathVariable("message") String message) {

        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message);

        /* 直接跟交换机MY_FANOUT_EXCHANGE交互 */
        rabbitTemplate.setExchange(RabbitConfig.MY_FANOUT_EXCHANGE);
        rabbitTemplate.convertAndSend(map);
        return "ok";
    }

    /**
     * 【Topic通配符模式】
     * @param message 消息内容
     **/
    @PostMapping("/topic/{message}")
    public String sendTopicMessage(@PathVariable("message") String message) {

        Map<String, Object> map = new HashMap<>();

        /* 直接跟交换机MY_FANOUT_EXCHANGE交互 */
        rabbitTemplate.setExchange(RabbitConfig.MY_TOPIC_EXCHANGE);

        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message + "TEST1");
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_ROUTING_KEY_ONE,map);

        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message + "TEST2");
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_ROUTING_KEY_TWO,map);

        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message + "TEST3");
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_ROUTING_KEY_THREE,map);

        return "ok";
    }


    /**
     * 【ack】
     * @param message 消息内容
     **/
    @PostMapping("/ack/{message}")
    public String ackMessage(@PathVariable("message") String message) {

        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message);

        /* 设置路由标识MY_ROUTING_KEY，发送到交换机MY_DIRECT_EXCHANGE */
        rabbitTemplate.convertAndSend(RabbitConfig.MY_DIRECT_EXCHANGE, RabbitConfig.ROUTING_KEY_ACK, map);
        return "ok";
    }
}