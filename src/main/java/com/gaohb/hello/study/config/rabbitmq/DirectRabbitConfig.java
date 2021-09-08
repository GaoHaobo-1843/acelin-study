package com.gaohb.hello.study.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {

    public static final String MY_DIRECT_EXCHANGE = "myDirectExchange"; // Direct交换机名称
    public static final String DIRECT_QUEUE_ONE = "directQueue-1";      // Direct队列名称1
    public static final String ROUTING_KEY_ONE = "routingKey-1";        // 路由标识1
    public static final String DIRECT_QUEUE_TWO = "directQueue-2";      // Direct队列名称2
    public static final String DIRECT_QUEUE_THREE = "directQueue-3";    // Direct队列名称2

    /* 声明队列（告诉服务器给我创建一个新的队列） */
    @Bean
    public Queue directQueueOne() {
        return new Queue(DIRECT_QUEUE_ONE,true);
    }

    @Bean
    public Queue directQueueTwo() {
        return new Queue(DIRECT_QUEUE_TWO,true);
    }

    @Bean
    public Queue directQueueThree() {
        return new Queue(DIRECT_QUEUE_THREE,true);
    }

    @Bean
    DirectExchange directExchange() {
          return new DirectExchange(MY_DIRECT_EXCHANGE,true,true);
    }

    @Bean
    Binding bindingDirectOne() {
        return BindingBuilder.bind(directQueueOne()).to(directExchange()).with(ROUTING_KEY_ONE);
    }

    @Bean
    Binding bindingDirectTwo() {
        return BindingBuilder.bind(directQueueTwo()).to(directExchange()).with(ROUTING_KEY_ONE);
    }

//    @Bean
//    Binding bindingDirectThree() {
//        return BindingBuilder.bind(directQueueTwo()).to(DirectExchange.DEFAULT).with(ROUTING_KEY_ONE);
//    }

}
