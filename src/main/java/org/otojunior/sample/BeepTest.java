package org.otojunior.sample;

import org.otojunior.sample.interfaces.IKernel32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class BeepTest {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(BeepTest.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		LOG.info("" + IKernel32.INSTANCE.Beep(440, 500));
		LOG.info("" + IKernel32.INSTANCE.Sleep(500));
		LOG.info("" + IKernel32.INSTANCE.Beep(500, 200));
	}
}
