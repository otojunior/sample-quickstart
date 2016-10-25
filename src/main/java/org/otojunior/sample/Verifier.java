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
 * @author Oto Junior
 *
 */
public class Verifier {
	private static final Logger LOG = LoggerFactory.getLogger(Verifier.class);
	
	private String signatureAlgorithm;
	private String hashAlgorithm;
	
	/**
	 * Default constructor.
	 */
	public Verifier(String signatureAlgorithm, String hashAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
		this.hashAlgorithm = hashAlgorithm;
	}
	
	/**
	 * 
	 */
	public boolean verify(String message, PublicKey publicKey, byte[] sign) {
		boolean authentic = false; 
		try {
			Signature signature = Signature.getInstance(signatureAlgorithm);
			signature.initVerify(publicKey);
			signature.update(message.getBytes());
			authentic = signature.verify(sign);
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			LOG.error(e.getMessage(), e);
		}
		return authentic;
	}
	
	/**
	 * 
	 */
	public boolean verifyWithHash(String message, PublicKey publicKey, byte[] sign) {
		boolean authentic = false;
		try {
			MessageDigest digester = MessageDigest.getInstance(hashAlgorithm);
			digester.update(message.getBytes());
			byte[] hash = digester.digest();
			
			Signature signature = Signature.getInstance(signatureAlgorithm);
			signature.initVerify(publicKey);
			signature.update(hash);
			authentic = signature.verify(sign);
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			LOG.error(e.getMessage(), e);
		}
		return authentic;
	}
}
