/**
 * 
 */
package org.otojunior.sample;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oto Junior
 *
 */
public class BlockCipher {
	private static final Logger LOG = LoggerFactory.getLogger(BlockCipher.class);
	
	private Cipher cipher;
	
	/**
	 * 
	 * @param algorithm
	 */
	public BlockCipher(String algorithm) {
		try {
			this.cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			LOG.error(e.getMessage(), e);
		} 
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
			this.cipher.init(mode, key);
			processed = cipher.doFinal(message);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return processed;
	}
}
