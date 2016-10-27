package org.otojunior.sample.block.symmetrical;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;
import org.otojunior.sample.block.BlockCipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 *
 * @author [Author name]
 * @version $Id: $Id
 */
public class TestApp {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(TestApp.class);
	
	private static final String STR_MESSAGE = "Não obstante, a contínua expansão de nossa atividade "
			+ "pode nos levar a considerar a reestruturação do investimento "
			+ "em reciclagem técnica. O empenho em analisar a adoção de "
			+ "políticas descentralizadoras facilita a criação do retorno "
			+ "esperado a longo prazo. Ainda assim, existem dúvidas a respeito "
			+ "de como o surgimento do comércio virtual prepara-nos para "
			+ "enfrentar situações atípicas decorrentes do fluxo de informações.";
	
	private static final byte[] ORIGINAL_MESSAGE = STR_MESSAGE.getBytes();
	
	/**
	 * Application main method.
	 *
	 * @param args Command line arguments.
	 * @throws java.security.NoSuchAlgorithmException if any.
	 */
	public static void main(String[] args) {
		LOG.info("sample-quickstart Application.");
		
		test("DES", 56, "DES/ECB/PKCS5Padding");
		test("AES", 128, "AES/ECB/PKCS5Padding");
		test("AES", "p@ssW0rd!C00L#Ok".getBytes(), "AES/ECB/PKCS5Padding");
	}
	
	/**
	 * 
	 * @param keygenAlgorithm
	 * @param keySize
	 * @param cipherAlgorithm
	 * @throws NoSuchAlgorithmException
	 */
	public static void test(String keygenAlgorithm, int keySize, String cipherAlgorithm) {
		SecretKey key = SecretKeyFactory.generate(keygenAlgorithm, keySize);
		process(cipherAlgorithm, key);
	}
	
	/**
	 * 
	 * @param keygenAlgorithm
	 * @param keySize
	 * @param cipherAlgorithm
	 * @throws NoSuchAlgorithmException
	 */
	public static void test(String keygenAlgorithm, byte[] specifiedKey, String cipherAlgorithm) {
		SecretKey key = SecretKeyFactory.generate(keygenAlgorithm, specifiedKey);
		process(cipherAlgorithm, key);
	}

	/**
	 * @param cipherAlgorithm
	 * @param key
	 */
	private static void process(String cipherAlgorithm, SecretKey key) {
		BlockCipher cipher = new BlockCipher(cipherAlgorithm);
		byte[] encrypted = cipher.process(ORIGINAL_MESSAGE, key, Cipher.ENCRYPT_MODE);
		
		LOG.info("Message: " + ORIGINAL_MESSAGE.length + " " + Hex.encodeHexString(ORIGINAL_MESSAGE));
		LOG.info("Encypted: " + encrypted.length + " " + Hex.encodeHexString(encrypted));
		
		cipher = new BlockCipher(cipherAlgorithm);
		byte[] decrypted = cipher.process(encrypted, key, Cipher.DECRYPT_MODE);
		
		LOG.info("Decrypted: " + decrypted.length + " " + Hex.encodeHexString(decrypted));
		LOG.info("Original equals Decrypted? " + Arrays.equals(ORIGINAL_MESSAGE, decrypted));
		
		LOG.info("------------------------------------------------------------------------------");
	}
}
