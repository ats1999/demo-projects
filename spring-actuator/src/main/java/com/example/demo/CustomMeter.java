package com.example.demo;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Component
public class CustomMeter {
	public CustomMeter(MeterRegistry meterRegistry) {
		Counter c = meterRegistry.counter("custom.meter", Tags.empty());
		c.increment();
	}
}
