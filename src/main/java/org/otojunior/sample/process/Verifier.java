/**
 * 
 */
package org.otojunior.sample.process;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Verifier class.</p>
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public class Verifier {
	private static final Logger LOG = LoggerFactory.getLogger(Verifier.class);
	
	private String signatureAlgorithm;
	
	/**
	 * Default constructor.
	 *
	 * @param signatureAlgorithm a {@link java.lang.String} object.
	 * @param hashAlgorithm a {@link java.lang.String} object.
	 */
	public Verifier(String signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
	}
	
	/**
	 * <p>verify.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param publicKey a {@link java.security.PublicKey} object.
	 * @param sign an array of byte.
	 * @return a boolean.
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
}
