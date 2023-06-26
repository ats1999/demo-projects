package com.example.demo.websocket.config.events;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionConnectEvent;

public class WebSocketSessionConnectEvent implements ApplicationListener<SessionConnectEvent> {

	@Override
	public void onApplicationEvent(SessionConnectEvent event) {
		// noop
	}

}
