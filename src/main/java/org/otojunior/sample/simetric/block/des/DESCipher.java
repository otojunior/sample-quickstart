/**
 * 
 */
package org.otojunior.sample.simetric.block.des;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oto Junior
 *
 */
public class DESCipher {
	private static final Logger LOG = LoggerFactory.getLogger(DESCipher.class);
	
	private String algorithm;
	
	/**
	 * 
	 * @param algorithm
	 */
	public DESCipher(String algorithm) {
		this.algorithm = algorithm;
	}
	
	/**
	 * 
	 * @param message
	 * @param key
	 */
	public byte[] encrypt(String message, SecretKey key) {
		byte[] encrypted = null;
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypted = cipher.doFinal(message.getBytes());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return encrypted;
	}
	
	/**
	 * 
	 * @param message
	 * @param key
	 */
	public String decrypt(byte[] message, SecretKey key) {
		String msgDecrypted = null;
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decrypted = cipher.doFinal(message);
			msgDecrypted = new String(decrypted);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return msgDecrypted;
	}
}
