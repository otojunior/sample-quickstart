package org.otojunior.sample;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Keys class.</p>
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public class KeyPairFactory {
	private static final Logger LOG = LoggerFactory.getLogger(KeyPairFactory.class);
	
	/**
	 * 
	 */
	public static KeyPair generate(String algorithm, int keysize) {
		KeyPair keys = null;
		try {
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
			
			/*
			 * Key Generation.
			 */
			KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
			generator.initialize(keysize, rnd);
			keys = generator.generateKeyPair();
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("Private Key: " + 
					keys.getPrivate().getEncoded().length + " " + 
					keys.getPrivate().getFormat() + " " + 
					Hex.encodeHexString(keys.getPrivate().getEncoded()));
				
				LOG.debug("Private Key: " + 
					keys.getPublic().getEncoded().length + " " + 
					keys.getPublic().getFormat() + " " + 
					Hex.encodeHexString(keys.getPublic().getEncoded()));
			}
		} catch (NoSuchAlgorithmException e) {
			LOG.error(e.getMessage(), e);
		}
		return keys;
	}
}
