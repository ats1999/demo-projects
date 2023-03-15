package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@RestController
public class Hello {
	
	private MeterRegistry meterRegistry;
	
	Hello(MeterRegistry meterRegistry){
		this.meterRegistry = meterRegistry;
	}
	
	@GetMapping("/hello")
	public boolean hello() {
		Counter c = meterRegistry.counter("custom.meter", Tags.empty());
		c.increment();
		return this.meterRegistry != null;
	}
	
}
