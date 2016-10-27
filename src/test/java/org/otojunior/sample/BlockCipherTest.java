/**
 * 
 */
package org.otojunior.sample;

import static org.junit.Assert.assertTrue;

import java.security.Key;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class BlockCipherTest {
	private static final Logger LOG = LoggerFactory.getLogger(BlockCipherTest.class);

	private static final String STR_MESSAGE = "Não obstante, a contínua expansão de nossa atividade "
			+ "pode nos levar a considerar a reestruturação do investimento "
			+ "em reciclagem técnica. O empenho em analisar a adoção de "
			+ "políticas descentralizadoras facilita a criação do retorno "
			+ "esperado a longo prazo. Ainda assim, existem dúvidas a respeito "
			+ "de como o surgimento do comércio virtual prepara-nos para "
			+ "enfrentar situações atípicas decorrentes do fluxo de informações.";
	
	private static final byte[] ORIGINAL_MESSAGE = STR_MESSAGE.getBytes();

	/**
	 * Test method for {@link org.otojunior.sample.BlockCipher#process(byte[], java.security.Key, int)}.
	 */
	@Test
	public final void testSymmetricalDES() {
		int keySize = 56;
		String keygenAlgorithm = "DES";
		String cipherAlgorithm = "DES/ECB/PKCS5Padding";
		
		Key key = SecretKeyFactory.generate(keygenAlgorithm, keySize);
		BlockCipher cipher = new BlockCipher(cipherAlgorithm);
		test(key, cipher);
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.BlockCipher#process(byte[], java.security.Key, int)}.
	 */
	@Test
	public final void testSymmetricalAES() {
		int keySize = 128;
		String keygenAlgorithm = "AES";
		String cipherAlgorithm = "AES/ECB/PKCS5Padding";
		
		Key key = SecretKeyFactory.generate(keygenAlgorithm, keySize);
		BlockCipher cipher = new BlockCipher(cipherAlgorithm);
		test(key, cipher);
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.BlockCipher#process(byte[], java.security.Key, int)}.
	 */
	@Test
	public final void testSymmetricalAESWithSpecifiedPassword() {
		String specifiedPassword = "p@ssW0rd!C00L#Ok";
		String keygenAlgorithm = "AES";
		String cipherAlgorithm = "AES/ECB/PKCS5Padding";
		
		Key key = SecretKeyFactory.generate(keygenAlgorithm, specifiedPassword.getBytes());
		BlockCipher cipher = new BlockCipher(cipherAlgorithm);
		test(key, cipher);
	}
	
	/**
	 * 
	 * @param keygenAlgorithm
	 * @param keySize
	 * @param cipherAlgorithm
	 * @return
	 */
	private void test(Key key, BlockCipher cipher) {
		byte[] encrypted = cipher.process(ORIGINAL_MESSAGE, key, Cipher.ENCRYPT_MODE);
		byte[] decrypted = cipher.process(encrypted, key, Cipher.DECRYPT_MODE);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Message: " + ORIGINAL_MESSAGE.length + " " + Hex.encodeHexString(ORIGINAL_MESSAGE));
			LOG.debug("Encypted: " + encrypted.length + " " + Hex.encodeHexString(encrypted));
			LOG.debug("Decrypted: " + decrypted.length + " " + Hex.encodeHexString(decrypted));
		}
		
		assertTrue(Arrays.equals(ORIGINAL_MESSAGE, decrypted));
	}
}
