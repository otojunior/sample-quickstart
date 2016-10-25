/**
 * 
 */
package org.otojunior.sample;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author homologa
 *
 */
public class Verifier {
	private static final Logger LOG = LoggerFactory.getLogger(Verifier.class);
	
	private PublicKey publicKey;
	
	/**
	 * 
	 */
	public Verifier() {
		publicKey = (PublicKey)Memory.keys.get("publicKey");
	}
	
	/**
	 * 
	 */
	public void verify(String message) {
		try {
			byte[] sign = Memory.signs.get("signFullMessage");
			
			Signature signature = Signature.getInstance("DSA");
			signature.initVerify(publicKey);
			signature.update(message.getBytes());
			boolean authentic = signature.verify(sign);
			
			LOG.info("Is Authentic? " + authentic);
			
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 */
	public void verifyWithHash(String message) {
		try {
			MessageDigest digester = MessageDigest.getInstance("MD5");
			digester.update(message.getBytes());
			byte[] hash = digester.digest();
			
			byte[] sign = Memory.signs.get("signHashMessage");
			
			Signature signature = Signature.getInstance("DSA");
			signature.initVerify(publicKey);
			signature.update(hash);
			boolean authentic = signature.verify(sign);
			
			LOG.info("Is Authentic? " + authentic);
			
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
