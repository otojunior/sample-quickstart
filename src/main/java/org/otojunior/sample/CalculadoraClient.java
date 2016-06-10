package org.otojunior.sample;

import org.otojunior.sample.soap.CalculadoraWSService;
import org.otojunior.sample.soap.ICalculadoraWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class CalculadoraClient {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(CalculadoraClient.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		LOG.info("sample-quickstart Application.");
		
		CalculadoraWSService service = new CalculadoraWSService();
		ICalculadoraWS port = service.getCalculadoraWSPort();
		
		LOG.info("Soma: " + port.somar(2, 3));
		LOG.info("Subtração: " + port.subtrair(10, 3));
		LOG.info("Multiplicar: " + port.multiplicar(5, 7));
		LOG.info("Dividir: " + port.dividir(24, 10));
	}
}

