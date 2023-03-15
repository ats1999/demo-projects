package com.logging.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		logger.warn("Hello");
		
		// logging exception stack trace
		try {
			int a = 90/0;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

}
