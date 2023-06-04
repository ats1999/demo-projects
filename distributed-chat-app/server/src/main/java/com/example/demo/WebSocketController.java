package com.example.demo;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/user")
public class WebSocketController {
	
	@MessageMapping("/{id}")
	public String greet(String message, @DestinationVariable String id) throws Exception {
		return "Hello, " + message;
	}

}
