package org.otojunior.sample;

import java.security.NoSuchAlgorithmException;

import org.otojunior.sample.keys.Keys;
import org.otojunior.sample.process.Signer;
import org.otojunior.sample.process.Verifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 *
 * @author [Author name]
 * @version $Id: $Id
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	private static final String KEYGEN_ALGORITHM = "DSA";
	private static final String SIGNATURE_ALGORITHM = "SHA256withDSA";
	
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
		
		Keys keys = new Keys(KEYGEN_ALGORITHM);
		keys.generate();
		
		Signer signer = new Signer(SIGNATURE_ALGORITHM);
		byte[] sign = signer.sign(message, keys.getPrivateKey());
		
		Verifier verifier = new Verifier(SIGNATURE_ALGORITHM);
		boolean auth = verifier.verify(message, keys.getPublicKey(), sign);
		
		LOG.info("Authentic? " + auth);
		
	}
}
