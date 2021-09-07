package com.gaohb.hello.study.springTest.amqp.rabbitmq;

import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/rabbitmq")
public class HelloRabbitMQ {

    private static final String QUEUE_NAME = "acelin_queue"; // 定义消息队列的名称
    private static final String WORK_QUEUE = "work_queue";   // 工作队列

    @Autowired
    private Connection connection;

    /**
     * 消息生产者
     **/
    public void producer() throws Exception {

//        Connection connection = ConnectionUtil.getConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        Channel channel = getChannel(QUEUE_NAME,false,false,false,null);

        /* 消息发送 */
        String message = "Hello Acelin！";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes(StandardCharsets.UTF_8));
        System.out.println(" [producer] Sent '" + message + "'");

        /* 资源关闭 */
        channel.close();

    }

    /**
     * 消息消费者
     **/
    public void consumer() throws Exception{

//        Connection connection = ConnectionUtil.getConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        Channel channel = getChannel(QUEUE_NAME,false,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

//                String exchange = envelope.getExchange();             // 交换机

                int i = 1/0;

                String msg = new String(body,StandardCharsets.UTF_8); // body 即消息体
                System.out.println(" [consumer] received : " + msg + "!");

                /* 手动ack */
                long deliveryTag = envelope.getDeliveryTag();         // 消息id，mq在channel中用来标识消息的id，可用于确认消息已接收
                channel.basicAck(deliveryTag,false);
            }

        };

        /* 手动ack时，第二个参数为false */
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }

    /**
     * 工作队列模式【竞争消费者模式】 - 生产者
     **/
    @RequestMapping("/wq-producer")
    public void workQueueProducer()throws IOException,TimeoutException,InterruptedException{

        Channel channel = getChannel(WORK_QUEUE,false,false,false,null);

        /* 发布多个任务 */
        for (int i = 0; i < 100; i++) {

            String message = "task - " + i; // 消息内容
            channel.basicPublish("", WORK_QUEUE, null, message.getBytes());
            System.out.println(" [work_queue_producer] Sent '" + message + "'");
            Thread.sleep(i * 2);
        }

        channel.close(); // 关闭通道
    }

    /**
     * 工作队列模式【竞争消费者模式】 - 消费者1
     **/

    @RequestMapping("/wq-consumer1")
    public void workQueueConsumer1() throws IOException{

        Channel channel = getChannel(WORK_QUEUE,false,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String msg = new String(body,StandardCharsets.UTF_8);
                System.out.println(" [work_queue_consumer1] received : " + msg + "!");

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                /* 手动ack */
                long deliveryTag = envelope.getDeliveryTag();         // 消息id，mq在channel中用来标识消息的id，可用于确认消息已接收
                channel.basicAck(deliveryTag,false);

            }

        };

        channel.basicConsume(WORK_QUEUE, false, consumer);

    }

    /**
     * 工作队列模式【竞争消费者模式】 - 消费者1
     **/
    @RequestMapping("/wq-consumer2")
    public void workQueueConsumer2() throws IOException{
        Channel channel = getChannel(WORK_QUEUE,false,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String msg = new String(body,StandardCharsets.UTF_8);
                System.out.println(" [work_queue_consumer2] received : " + msg + "!");

                /* 手动ack */
                long deliveryTag = envelope.getDeliveryTag();         // 消息id，mq在channel中用来标识消息的id，可用于确认消息已接收
                channel.basicAck(deliveryTag,false);
            }
        };

        channel.basicConsume(WORK_QUEUE, false, consumer);
    }

    /**
     * 获取管道
     * @param queueName 【消息队列名称】
     * @param durable 【是否持久化】 如果持久化，mq重启后队列还在
     * @param exclusive 【是否独占连接】 队列只允许在该连接中访问，如果connection连接关闭队列则自动删除
     * @param autoDelete 【是否自动删除】 队列不再使用时是否自动删除此队列
     * @param args 【队列扩展参数】 比如：队列存活时间等
     *
     * exclusive和autoDelete都设置为true可用于临时队列的创建
     **/

    private Channel getChannel(String queueName,boolean durable,boolean exclusive,boolean autoDelete, Map<String, Object> args) throws IOException {
//        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queueName,durable,exclusive,autoDelete,args);
        channel.basicQos(1);
        return channel;
    }


}
