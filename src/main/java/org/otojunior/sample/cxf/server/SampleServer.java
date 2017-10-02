/**
 * 
 */
package org.otojunior.sample.cxf.server;

import javax.xml.ws.Endpoint;

import org.otojunior.sample.cxf.entidade.Calculadora;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class SampleServer implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(SampleServer.class);
	
	/**
	 * {@inheritDoc}  
	 */
	@Override
	public void run() {
		final String ADDRESS = "http://localhost:9000/calculadoraws";
		final Calculadora IMPLEMENTACAO = new Calculadora();
	
		LOG.info("Servidor iniciado...");
		Endpoint.publish(ADDRESS, IMPLEMENTACAO);
		
		try {
			Thread.sleep(1 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LOG.info("Servidor terminado...");
        System.exit(0);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new SampleServer()).start();
	}
}
