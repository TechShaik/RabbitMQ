package com.files.RabbitMq.dto;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.files.RabbitMq.config.MessageConfig;

@RestController
@RequestMapping("/order")
public class Controller {
	@Autowired
private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/{restaurent_name}")
	public String bookOrder(@RequestBody Order order,@PathVariable String restaurent_name) {
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderStatus orderStatus=new OrderStatus(order,"process","order placed successfully"+restaurent_name);
		rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.RO,orderStatus);
		return "Success";
		
	}
	
	
	
	
}
