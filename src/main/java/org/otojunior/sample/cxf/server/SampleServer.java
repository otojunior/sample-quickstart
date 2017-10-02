/**
 * 
 */
package org.otojunior.sample.cxf.server;

import javax.xml.ws.Endpoint;

import org.otojunior.sample.cxf.entidade.Calculadora;

/**
 * @author 01456231650
 *
 */
public class SampleServer implements Runnable {
	/**
	 * {@inheritDoc}  
	 */
	@Override
	public void run() {
		final String ADDRESS = "http://localhost:9000/calculadoraws";
		final Calculadora IMPLEMENTACAO = new Calculadora();
		
		System.out.println("Server iniciado...");
		Endpoint.publish(ADDRESS, IMPLEMENTACAO);
		
		try {
			Thread.sleep(5 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Server terminado...");
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
