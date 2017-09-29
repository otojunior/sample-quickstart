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
		Endpoint.publish(ADDRESS, IMPLEMENTACAO);
	}
}
