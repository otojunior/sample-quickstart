/**
 * 
 */
package org.otojunior.sample.process;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Signer class.</p>
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public class Signer {
	private static final Logger LOG = LoggerFactory.getLogger(Signer.class);
	
	/**
	 * 
	 */
	private String signatureAlgorithm;
	
	/**
	 * Default constructor.
	 *
	 * @param signatureAlgorithm a {@link java.lang.String} object.
	 * @param hashAlgorithm a {@link java.lang.String} object.
	 */
	public Signer(String signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
	}
	
	/**
	 * <p>sign.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param privateKey a {@link java.security.PrivateKey} object.
	 * @return an array of byte.
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
}
