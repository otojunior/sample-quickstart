package org.otojunior.sample.simetric.application;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;
import org.otojunior.sample.simetric.block.BlockCipher;
import org.otojunior.sample.simetric.keys.SecretKeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 *
 * @author [Author name]
 * @version $Id: $Id
 */
public class TestAppDES {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(TestAppDES.class);
	
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
		byte[] original = message.getBytes();
		
		SecretKey key = SecretKeyFactory.generate(KEYGEN_ALGORITHM, 56);
		
		BlockCipher cipher = new BlockCipher(CIPHER_ALGORITHM);
		byte[] encrypted = cipher.process(original, key, Cipher.ENCRYPT_MODE);
		
		LOG.info("Message: " + original.length + " " + Hex.encodeHexString(original));
		LOG.info("Encypted: " + encrypted.length + " " + Hex.encodeHexString(encrypted));
		
		cipher = new BlockCipher(CIPHER_ALGORITHM);
		byte[] decrypted = cipher.process(encrypted, key, Cipher.DECRYPT_MODE);
		
		LOG.info("Decrypted: " + decrypted.length + " " + Hex.encodeHexString(decrypted));
		LOG.info("Original equals Decrypted? " + Arrays.equals(original, decrypted));
	}
}
