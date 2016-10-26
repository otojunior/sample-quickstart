package org.otojunior.sample.keys;

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
 * <p>Keys class.</p>
 *
 * @author homologa
 * @version $Id: $Id
 */
public class Keys {
	private static final Logger LOG = LoggerFactory.getLogger(Keys.class);
	
	private String algorithm;
	private PublicKey publicKey;
	private PrivateKey privateKey;
	
	/**
	 * 
	 * @param keygenAlgorithm
	 */
	public Keys(String keygenAlgorithm) {
		this.algorithm = keygenAlgorithm;
	}

	/**
	 * <p>generate.</p>
	 */
	public void generate() {
		try {
			SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
			
			// Key Pair generator.
			KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
			generator.initialize(512, rnd);
			KeyPair keys = generator.generateKeyPair();
			
			publicKey = keys.getPublic();
			privateKey = keys.getPrivate();
			
			LOG.info("Public Key: " + 
				publicKey.getEncoded().length + " " + 
				publicKey.getFormat() + " " + 
				Hex.encodeHexString(publicKey.getEncoded()));
			
			LOG.info("Private Key: " + 
				privateKey.getEncoded().length + " " + 
				privateKey.getFormat() + " " + 
				Hex.encodeHexString(privateKey.getEncoded()));
			
		} catch (NoSuchAlgorithmException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * <p>Getter for the field <code>publicKey</code>.</p>
	 *
	 * @return the publicKey
	 */
	public PublicKey getPublicKey() {
		return publicKey;
	}

	/**
	 * <p>Getter for the field <code>privateKey</code>.</p>
	 *
	 * @return the privateKey
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
}
