package org.otojunior.sample;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LOG.info("info message.");
		LOG.debug("debug message.");
		LOG.trace("trace message.");
	}
}
