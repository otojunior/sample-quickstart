/**
 * 
 */
package org.otojunior.sample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
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
		Keys keys = new Keys();
		keys.generate();
		pk = keys.getPrivateKey();
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
			
			FileOutputStream out = new FileOutputStream("signature.dat"); 
			IOUtils.write(sign, out);
			IOUtils.closeQuietly(out);
			
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException | IOException e) {
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
			
			FileOutputStream out = new FileOutputStream("signature-hash.dat"); 
			IOUtils.write(sign, out);
			IOUtils.closeQuietly(out);
			
		} catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException | IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
