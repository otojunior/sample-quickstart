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
 * @author Oto Junior
 *
 */
public class Signer {
	private static final Logger LOG = LoggerFactory.getLogger(Signer.class);
	
	private String signatureAlgorithm;
	private String hashAlgorithm;
	
	/**
	 * Default constructor.
	 */
	public Signer(String signatureAlgorithm, String hashAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
		this.hashAlgorithm = hashAlgorithm;
	}
	
	/**
	 * 
	 * @param message
	 */
	public byte[] sign(String message, PrivateKey privateKey) {
		byte[] sign = null;
		try {
			Signature signature = Signature.getInstance(signatureAlgorithm);
			signature.initSign(privateKey);
			signature.update(message.getBytes());
			sign = signature.sign();
			LOG.info("Assinatura: " + String.valueOf(sign.length) + " " + Hex.encodeHexString(sign));
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
			LOG.error(e.getMessage(), e);
		}
		return sign;
	}
	
	/**
	 * 
	 * @param message
	 * @return 
	 */
	public byte[] signWithHash(String message, PrivateKey privateKey) {
		byte[] sign = null;
		try {
			MessageDigest digester = MessageDigest.getInstance(hashAlgorithm);
			digester.update(message.getBytes());
			byte[] hash = digester.digest();
			
			LOG.info("Hash: " + hash.length + " " + Hex.encodeHexString(hash));
			
			Signature signature = Signature.getInstance(signatureAlgorithm);
			signature.initSign(privateKey);
			signature.update(hash);
			sign = signature.sign();
			
			LOG.info("Assinatura: " + String.valueOf(sign.length) + " " + Hex.encodeHexString(sign));
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
			LOG.error(e.getMessage(), e);
		}
		return sign;
	}
}
