package org.otojunior.sample;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws NoSuchAlgorithmException 
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
		
		Keys keys = new Keys();
		keys.generate();
		Memory.keys.put("privateKey", keys.getPrivateKey());
		Memory.keys.put("publicKey", keys.getPublicKey());
		
		Signer signer = new Signer();
		signer.sign(message);
		signer.signWithHash(message);
		
		Verifier verifier = new Verifier();
		verifier.verify(message);
		verifier.verifyWithHash(message);
	}
}
