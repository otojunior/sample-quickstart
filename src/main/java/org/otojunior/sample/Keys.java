package org.otojunior.sample;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author homologa
 *
 */
public class Keys {
	private static final Logger LOG = LoggerFactory.getLogger(Keys.class);
	
	private PublicKey publicKey;
	private PrivateKey privateKey;
	
	public void generate() {
		try {
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
			
			// Key Pair generator.
			KeyPairGenerator generator = KeyPairGenerator.getInstance("DSA");
			generator.initialize(512, rnd);
			KeyPair keys = generator.generateKeyPair();
			
			publicKey = keys.getPublic();
			privateKey = keys.getPrivate();
			
			LOG.info("Public Key: " + publicKey.getFormat() + " " + Hex.encodeHexString(publicKey.getEncoded()));
			LOG.info("Private Key: " + privateKey.getFormat() + " " + Hex.encodeHexString(privateKey.getEncoded()));
		} catch (NoSuchAlgorithmException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * @return the publicKey
	 */
	public PublicKey getPublicKey() {
		return publicKey;
	}

	/**
	 * @return the privateKey
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
}
