package com.gaohb.hello.study.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {

    public static final String MY_DIRECT_EXCHANGE = "myDirectExchange";              // Direct交换机名称
    public static final String MY_FANOUT_EXCHANGE = "myFanoutExchange";              // Fanout交换机名称
    public static final String MY_TOPIC_EXCHANGE = "myTopicExchange";                // Topic交换机名称

    public static final String ROUTING_KEY_ONE = "direct.routing-key-1";             // direct路由标识1
    public static final String ROUTING_KEY_TWO = "topic.routing-key.*";              // topic路由匹配1
    public static final String ROUTING_KEY_THREE = "topic.routing-key.#";            // topic路由匹配2

    public static final String TOPIC_ROUTING_KEY_ONE = "topic.routing-key";          // topic路由标识1
    public static final String TOPIC_ROUTING_KEY_TWO = "topic.routing-key.k1";       // topic路由标识2
    public static final String TOPIC_ROUTING_KEY_THREE = "topic.routing-key.k1.kk2"; // topic路由标识2

    public static final String DIRECT_QUEUE_ONE = "directQueue-1";                   // Direct队列名称1
    public static final String DIRECT_QUEUE_TWO = "directQueue-2";                   // Direct队列名称2
    public static final String DIRECT_QUEUE_THREE = "directQueue-3";                 // Direct队列名称3
    public static final String FANOUT_QUEUE_ONE = "fanout-queue-1";                  // Fanout队列名称1
    public static final String FANOUT_QUEUE_TWO = "fanout-queue-2";                  // Fanout队列名称2
    public static final String TOPIC_QUEUE_ONE = "topic-queue-1";                    // Topic队列名称1
    public static final String TOPIC_QUEUE_TWO = "topic-queue-2";                    // Topic队列名称2


    /* 声明队列（告诉服务器给我创建一个新的队列） */

    /******************************* Direct ******************************/
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
    public DirectExchange directExchange() {
          return new DirectExchange(MY_DIRECT_EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingDirectOne() {
        return BindingBuilder.bind(directQueueOne()).to(directExchange()).with(ROUTING_KEY_ONE);
    }

    @Bean
    public Binding bindingDirectTwo() {
        return BindingBuilder.bind(directQueueTwo()).to(directExchange()).with(ROUTING_KEY_ONE);
    }

    /******************************* Fanout ******************************/

    @Bean
    public Queue fanoutQueueOne() {
        return new Queue(FANOUT_QUEUE_ONE,true);
    }

    @Bean
    public Queue fanoutQueueTwo() {
        return new Queue(FANOUT_QUEUE_TWO,true);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(MY_FANOUT_EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingFanoutOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }


    /******************************* Topic ******************************/

    @Bean
    public Queue topicQueueOne() {
        return new Queue(TOPIC_QUEUE_ONE,true);
    }

    @Bean
    public Queue topicQueueTwo() {
        return new Queue(TOPIC_QUEUE_TWO,true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MY_TOPIC_EXCHANGE,true,false);
    }

    @Bean
    public Binding bindingTopicOne() {
        return BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with(ROUTING_KEY_TWO);
    }

    @Bean
    public Binding bindingTopicTwo() {
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with(ROUTING_KEY_THREE);
    }


}
