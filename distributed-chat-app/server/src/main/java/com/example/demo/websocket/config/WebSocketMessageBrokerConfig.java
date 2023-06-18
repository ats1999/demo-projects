package com.example.demo.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.example.demo.websocket.config.events.WebSocketSessionConnectEvent;
import com.example.demo.websocket.config.events.WebSocketSessionConnectedEvent;
import com.example.demo.websocket.config.events.WebSocketSessionDisconnectEvent;
import com.example.demo.websocket.config.events.WebSocketSessionSubscribeEvent;
import com.example.demo.websocket.config.events.WebSocketSessionUnsubscribeEvent;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/test").setAllowedOrigins("http://localhost:3000").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/topic", "/queue");
	}
	
	@Bean
	WebSocketSessionConnectEvent getSessionConnectEvent(){
		return new WebSocketSessionConnectEvent();
	}
	
	@Bean
	WebSocketSessionConnectedEvent getSessionConnectedEvent() {
		return new WebSocketSessionConnectedEvent();
	}
	
	@Bean
	WebSocketSessionDisconnectEvent getSessionDisconnectEvent() {
		return new WebSocketSessionDisconnectEvent();
	}
	
	@Bean 
	WebSocketSessionSubscribeEvent getSessionSubscribeEvent() {
		return new WebSocketSessionSubscribeEvent();
	}
	
	@Bean
	WebSocketSessionUnsubscribeEvent getSocketSessionUnsubscribeEvent() {
		return new WebSocketSessionUnsubscribeEvent();
	}
}
