package org.otojunior.sample;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
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
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		LOG.info("sample-quickstart Application.");
		
		NTPUDPClient client = new NTPUDPClient();
		client.setDefaultTimeout(5000);
		TimeInfo info = client.getTime(InetAddress.getByName("pool.ntp.org"), 123);
		LOG.info(info.toString());
	}
}
