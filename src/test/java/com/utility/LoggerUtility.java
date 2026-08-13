package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	private LoggerUtility() { // constructor can be private to prevent instantiation of the class
		// private constructor to prevent instantiation
	}

	public void getLogger() {

	}

	public static Logger getLogger(Class<?> clazz) {
		Logger logger = null;
		if (logger == null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
	}
}
