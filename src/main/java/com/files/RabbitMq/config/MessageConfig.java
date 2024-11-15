package com.files.RabbitMq.config;

 
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; import org.springframework.amqp.core.AmqpTemplate;
import  org.springframework.amqp.core.Binding;
 
@Configuration
public class MessageConfig {
         public static final String QUEUE="queue";
         public static final String EXCHANGE="exchange";
         public static final String RO="routing key";

	@Bean
 	    public Queue queue() {
	        return new Queue(QUEUE); // Specify a name for the queue
	    }
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}
	@Bean
	public   Binding binding(Queue queue, TopicExchange exchange) {
	    return BindingBuilder.bind(queue).to(exchange).with(RO);
	}
	
	@Bean
	public MessageConverter converter() {
	    return new Jackson2JsonMessageConverter();
	}

 	public AmqpTemplate template(ConnectionFactory connectionFactory) {
	    final RabbitTemplate rabbitTemplate = new RabbitTemplate( connectionFactory);
	    rabbitTemplate.setMessageConverter(converter());  
	    return rabbitTemplate;
	}

}
