/**
 * 
 */
package org.otojunior.sample;

import org.otojunior.sample.interfaces.IAdvApi32;
import org.otojunior.sample.interfaces.IKernel32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

/**
 * API Tests.
 * @author 01456231650
 */
public class APITests {
	private static final Logger LOG = LoggerFactory.getLogger(APITests.class);
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		beepTest();
		getComputerNameTest();
		getUsernameTest();
	}
	
	/**
	 * 
	 */
	private static void beepTest() {
		LOG.info("************* Beep Test ************");
		
		for (int i = 100; i < 1000; i+=100) {
			LOG.info("" + IKernel32.INSTANCE.Beep(i, 500));
			IKernel32.INSTANCE.Sleep(10);
		}
		LOG.info("");
	}
	
	/**
	 * 
	 */
	private static void getComputerNameTest() {
		LOG.info("************* Computer Name Test ************");
		
		char[] lpBuffer = new char[32];
		IntByReference lpnSize = new IntByReference(32);
		
		LOG.info("" + IKernel32.INSTANCE.GetComputerNameW(lpBuffer, lpnSize));
		LOG.info(Native.toString(lpBuffer));
		LOG.info("" + lpnSize.getValue());
		//LOG.info(Kernel32Util.getComputerName());
		LOG.info("");
	}
	
	/**
	 * 
	 */
	private static void getUsernameTest() {
		LOG.info("************* User Name Test ************");
		
		char[] lpBuffer = new char[32];
		IntByReference lpnSize = new IntByReference(32);
		
		LOG.info("" + IAdvApi32.INSTANCE.GetUserNameW(lpBuffer, lpnSize));
		LOG.info(Native.toString(lpBuffer));
		LOG.info("" + lpnSize.getValue());
		LOG.info("");
	}
}
