package com.example.demo.websocket.config.events;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

public class WebSocketSessionUnsubscribeEvent implements ApplicationListener<SessionUnsubscribeEvent>{

	@Override
	public void onApplicationEvent(SessionUnsubscribeEvent event) {
		System.out.println("SessionUnsubscribeEvent");
	}

}
