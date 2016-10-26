package org.otojunior.sample.simetric.keys;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Keys class.</p>
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public class SecretKeyFactory {
	private static final Logger LOG = LoggerFactory.getLogger(SecretKeyFactory.class);
	
	/**
	 * 
	 */
	public static SecretKey generate(String algorithm, int keysize) {
		SecretKey key = null;
		try {
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
			
			/*
			 * Key Generation.
			 */
			KeyGenerator generator = KeyGenerator.getInstance(algorithm);
			generator.init(keysize, rnd);
			key = generator.generateKey();
			
			LOG.info("Secret Key: " + 
				key.getEncoded().length + " " + 
				key.getFormat() + " " + 
				Hex.encodeHexString(key.getEncoded()));
		} catch (NoSuchAlgorithmException e) {
			LOG.error(e.getMessage(), e);
		}
		return key;
	}
}
