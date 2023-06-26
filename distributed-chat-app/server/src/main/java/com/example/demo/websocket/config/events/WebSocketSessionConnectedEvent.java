package com.example.demo.websocket.config.events;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

public class WebSocketSessionConnectedEvent implements ApplicationListener<SessionConnectedEvent> {

	@Override
	public void onApplicationEvent(SessionConnectedEvent event) {
		// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/socket/messaging/AbstractSubProtocolEvent.html#getMessage()
	}

}
