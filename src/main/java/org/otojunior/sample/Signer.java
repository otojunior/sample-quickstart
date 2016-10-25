/**
 * 
 */
package org.otojunior.sample;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author homologa
 *
 */
public class Signer {
	private static final Logger LOG = LoggerFactory.getLogger(Signer.class);
	
	private PrivateKey pk;
	
	/**
	 * Default constructor.
	 */
	public Signer() {
		pk = (PrivateKey)Memory.keys.get("privateKey");
	}
	
	/**
	 * 
	 * @param message
	 */
	public void sign(String message) {
		try {
			Signature signature = Signature.getInstance("DSA");
			signature.initSign(pk);
			signature.update(message.getBytes());
			byte[] sign = signature.sign();

			LOG.info("Assinatura: " + String.valueOf(sign.length) + " " + Hex.encodeHexString(sign));
			Memory.signs.put("signFullMessage", sign);
			
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * @param message
	 */
	public void signWithHash(String message) {
		try {
			MessageDigest digester = MessageDigest.getInstance("MD5");
			digester.update(message.getBytes());
			byte[] hash = digester.digest();
			
			LOG.info("Hash: " + hash.length + " " + Hex.encodeHexString(hash));
			
			Signature signature = Signature.getInstance("DSA");
			signature.initSign(pk);
			signature.update(hash);
			byte[] sign = signature.sign();

			LOG.info("Assinatura: " + String.valueOf(sign.length) + " " + Hex.encodeHexString(sign));
			Memory.signs.put("signHashMessage", sign);
			
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
