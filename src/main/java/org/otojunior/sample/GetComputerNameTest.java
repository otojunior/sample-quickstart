package org.otojunior.sample;

import org.otojunior.sample.interfaces.IKernel32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class GetComputerNameTest {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(GetComputerNameTest.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		char[] lpBuffer = new char[32];
		IntByReference lpnSize = new IntByReference(32);
		
		LOG.info("" + IKernel32.INSTANCE.GetComputerNameW(lpBuffer, lpnSize));
		LOG.info(Native.toString(lpBuffer));
		LOG.info(""+lpnSize.getValue());
		//LOG.info(Kernel32Util.getComputerName());
	}
}
