package org.otojunior.sample.simetric.block.des;

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
public class DESSecretKeyFactory {
	private static final Logger LOG = LoggerFactory.getLogger(DESSecretKeyFactory.class);
	
	/**
	 * 
	 */
	public static SecretKey generate(String algorithm) {
		SecretKey key = null;
		try {
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
			
			/*
			 * Key Generation.
			 */
			KeyGenerator generator = KeyGenerator.getInstance(algorithm);
			generator.init(56, rnd);
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
