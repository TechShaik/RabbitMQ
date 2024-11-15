package com.files.RabbitMq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.files.RabbitMq.config.MessageConfig;
import com.files.RabbitMq.dto.OrderStatus;

@Component
public class User {
@RabbitListener(queues=MessageConfig.QUEUE)
public void consumermessagefomqueue(OrderStatus orderStatus) {
	System.out.println("message recived from queue:"+orderStatus);
}
}
