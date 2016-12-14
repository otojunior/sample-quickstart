package org.otojunior.sample;

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
	 */
	public static void main(String[] args) {
		LOG.info("sample-quickstart Application.");
		
		byte[] x = new byte[8];
		x[0] = 103;
		x[1] = (byte)(x[0] + 17);
		x[2] = (byte)(x[1] - 39);
		x[3] = (byte)(x[2] + 17);
		x[4] = (byte)(x[3] - 28);
		x[5] = (byte)(x[4] - 20);
		x[6] = (byte)(x[5] + 66);
		x[7] = (byte)(x[6] - 30);
		byte a = x[0];
		x[0] = x[2];
		x[2] = a;
		a = x[1];
		x[1] = x[5];
		x[5] = a;
		
		// x = Q2gbFxtV
	}
}
