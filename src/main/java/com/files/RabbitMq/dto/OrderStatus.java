package com.files.RabbitMq.dto;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {
      private Order order;
      private String status;
      private String message;
		
	
		
	

}
