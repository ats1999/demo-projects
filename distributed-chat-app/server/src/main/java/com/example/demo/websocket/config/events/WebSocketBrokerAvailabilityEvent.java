package com.example.demo.websocket.config.events;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;

public class WebSocketBrokerAvailabilityEvent implements ApplicationListener<BrokerAvailabilityEvent> {

	@Override
	public void onApplicationEvent(BrokerAvailabilityEvent event) {
		System.out.println("BrokerAvailabilityEvent");
	}

}
