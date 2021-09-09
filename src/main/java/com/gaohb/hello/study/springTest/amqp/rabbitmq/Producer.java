package com.gaohb.hello.study.springTest.amqp.rabbitmq;


import com.gaohb.hello.study.config.rabbitmq.DirectRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/producer")
public class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 【工作队列】模式
     * @param task 消息内容
     **/
    @PostMapping("/work/{task}")
    public String sendWorkMessage(@PathVariable("task") String task){

        rabbitTemplate.convertAndSend(DirectRabbitConfig.MY_DIRECT_EXCHANGE,DirectRabbitConfig.ROUTING_KEY_ONE,task);
        return "ok";

    }

    /**
     * 【Direct】
     * @param message 消息内容
     **/
    @PostMapping("/direct/{message}")
    public String sendDirectMessage(@PathVariable("message") String message) {

        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message);

        /* 设置路由标识MY_ROUTING_KEY，发送到交换机MY_DIRECT_EXCHANGE */
        rabbitTemplate.convertAndSend(DirectRabbitConfig.MY_DIRECT_EXCHANGE,DirectRabbitConfig.ROUTING_KEY_ONE, map);
        return "ok";
    }

    /**
     * 【Fanout】
     * @param message 消息内容
     **/
    @PostMapping("/fanout/{message}")
    public String sendFanoutMessage(@PathVariable("message") String message) {

        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message);

        /* 直接跟交换机MY_FANOUT_EXCHANGE交互 */
        rabbitTemplate.setExchange(DirectRabbitConfig.MY_FANOUT_EXCHANGE);
        rabbitTemplate.convertAndSend(map);
        return "ok";
    }

    /**
     * 【Topic】
     * @param message 消息内容
     **/
    @PostMapping("/topic/{message}")
    public String sendTopicMessage(@PathVariable("message") String message) {

        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", message);

        /* 直接跟交换机MY_FANOUT_EXCHANGE交互 */
        rabbitTemplate.setExchange(DirectRabbitConfig.MY_FANOUT_EXCHANGE);
        rabbitTemplate.convertAndSend(map);
        return "ok";
    }
}