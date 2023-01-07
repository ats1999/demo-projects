package com.logging.log;

import java.util.logging.Logger;

public class Person {
	String name;
	static Logger LOGGER = Logger.getLogger(LoggingDemo.class.getName());
	public Person(String name) {
		this.name = name;
		LOGGER.warning("Constructor called!");
	}
	
	public String getName() {
		LOGGER.warning("getName called!");
		return this.name;
	}
}

