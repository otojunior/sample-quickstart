/**
 * 
 */
package org.otojunior.sample.block;

import java.security.Key;

import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oto Junior
 *
 */
public class BlockCipher {
	private static final Logger LOG = LoggerFactory.getLogger(BlockCipher.class);
	
	private String algorithm;
	
	/**
	 * 
	 * @param algorithm
	 */
	public BlockCipher(String algorithm) {
		this.algorithm = algorithm;
	}
	
	/**
	 * 
	 * @param message
	 * @param key
	 * @param mode
	 * @return
	 */
	public byte[] process(byte[] message, Key key, int mode) {
		byte[] processed = null;
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(mode, key);
			processed = cipher.doFinal(message);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return processed;
	}
}
