package com.gaohb.hello.study.config.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Connection getConnection() throws TimeoutException, IOException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");      // 服务地址
        connectionFactory.setPort(5672);             // 端口
        connectionFactory.setUsername("guest");      // 用户名
        connectionFactory.setPassword("guest");      // 密码
        connectionFactory.setVirtualHost("/");       // 设置虚拟机，一个mq服务可以设置多个虚拟机，每个虚拟机就相当于一个独立的mq

        return connectionFactory.newConnection();
    }
}
