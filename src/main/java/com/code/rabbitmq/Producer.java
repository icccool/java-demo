package com.code.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * Created by WANG on 2018/9/20 14:58
 */
public class Producer {

    public final static String QUEUE_NAME="rabbitMQ.test";


    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.96.154.183");
        factory.setPort(5672);
//        factory.setVirtualHost("/vir2");
        factory.setUsername("admin");
        factory.setPassword("123456");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "hola";
        //发布消息
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        connection.close();
    }

}
