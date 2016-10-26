package org.otojunior.sample.simetric.block.des;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;
import org.otojunior.sample.simetric.keys.SecretKeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 *
 * @author [Author name]
 * @version $Id: $Id
 */
public class DESTestMainApp {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(DESTestMainApp.class);
	
	private static final String KEYGEN_ALGORITHM = "DES";
	private static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
	
	/**
	 * Application main method.
	 *
	 * @param args Command line arguments.
	 * @throws java.security.NoSuchAlgorithmException if any.
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		LOG.info("sample-quickstart Application.");
		
		String message = "Não obstante, a contínua expansão de nossa atividade "
				+ "pode nos levar a considerar a reestruturação do investimento "
				+ "em reciclagem técnica. O empenho em analisar a adoção de "
				+ "políticas descentralizadoras facilita a criação do retorno "
				+ "esperado a longo prazo. Ainda assim, existem dúvidas a respeito "
				+ "de como o surgimento do comércio virtual prepara-nos para "
				+ "enfrentar situações atípicas decorrentes do fluxo de informações.";
		
		SecretKey key = SecretKeyFactory.generate(KEYGEN_ALGORITHM);
		
		DESCipher cipher = new DESCipher(CIPHER_ALGORITHM);
		byte[] encrypted = cipher.encrypt(message, key);
		
		LOG.info("Message: " + message.length() + " " + Hex.encodeHexString(message.getBytes()));
		LOG.info("Encypted: " + encrypted.length + " " + Hex.encodeHexString(encrypted));
		
		cipher = new DESCipher(CIPHER_ALGORITHM);
		String decrypted = cipher.decrypt(encrypted, key);
		
		LOG.info("Decrypted: " + decrypted.length() + " " + Hex.encodeHexString(decrypted.getBytes()));
		LOG.info("Original equals Decrypted? " + message.equals(decrypted));
	}
}
