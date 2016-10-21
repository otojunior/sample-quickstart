/**
 * 
 */
package org.otojunior.sample;

import java.security.InvalidKeyException;
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
	
	/**
	 * 
	 * @param message
	 */
	public void sign(String message) {
		Keys keys = new Keys();
		keys.generate();
		PrivateKey pk = keys.getPrivateKey();
		
		try {
			Signature signature = Signature.getInstance("DSA");
			signature.initSign(pk);
			signature.update(message.getBytes());
			
			byte[] sign = signature.sign();
			LOG.info(String.valueOf(sign.length));
			LOG.info(Hex.encodeHexString(sign));
			
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
