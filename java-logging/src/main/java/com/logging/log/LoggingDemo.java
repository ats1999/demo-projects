package com.logging.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo {
	static Logger LOGGER = Logger.getLogger(LoggingDemo.class.getName());
	public static void main(String[] args) {
		LOGGER.setLevel(Level.FINE);
		Person p = new Person("Rahul");
		p.getName();
	}

}
