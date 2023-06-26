package com.example.demo.websocket.config.events;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

public class WebSocketSessionSubscribeEvent implements  ApplicationListener<SessionSubscribeEvent>{

	@Override
	public void onApplicationEvent(SessionSubscribeEvent event) {
		System.out.println("SessionSubscribeEvent");
	}

}
