package org.otojunior.sample;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Set;

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
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		LOG.info("sample-quickstart Application.");
		
		Keys k = new Keys();
		k.generate();
	}
}
