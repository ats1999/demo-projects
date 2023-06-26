package com.example.demo.websocket.config.events;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

public class WebSocketSessionDisconnectEvent implements ApplicationListener<SessionDisconnectEvent> {

	@Override
	public void onApplicationEvent(SessionDisconnectEvent event) {
		System.out.println("SessionDisconnectEvent");
	}
	
}
