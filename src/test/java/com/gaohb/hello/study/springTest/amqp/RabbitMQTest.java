package com.gaohb.hello.study.springTest.amqp;

import com.gaohb.hello.study.springTest.amqp.rabbitmq.HelloRabbitMQ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private HelloRabbitMQ helloRabbitMQ;

    @Test
    public void producer(){
        try{
            helloRabbitMQ.producer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void consumer(){
        try{
            helloRabbitMQ.consumer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void wq_producer(){
        try{
            helloRabbitMQ.workQueueProducer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void wq_consumer1(){
        try{
            helloRabbitMQ.workQueueConsumer1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void wq_consumer2(){
        try{
            helloRabbitMQ.workQueueConsumer2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
