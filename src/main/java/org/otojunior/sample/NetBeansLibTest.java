/**
 * 
 */
package org.otojunior.sample;

import org.otojunior.sample.interfaces.INetBeansLib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class NetBeansLibTest {
	private static final Logger LOG = LoggerFactory.getLogger(NetBeansLibTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("soma: " + INetBeansLib.INSTANCE.soma(3, 6));
		LOG.info("diferennca: " + INetBeansLib.INSTANCE.dif(10, 8));
	}
}
