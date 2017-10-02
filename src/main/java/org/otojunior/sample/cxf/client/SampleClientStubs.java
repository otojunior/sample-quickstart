package org.otojunior.sample.cxf.client;

import org.otojunior.sample.cxf.entidade.Calculadora;
import org.otojunior.sample.cxf.entidade.CalculadoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author 01456231650
 *
 */
public class SampleClientStubs {
	private static final Logger LOG = LoggerFactory.getLogger(SampleClientStubs.class);
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CalculadoraService service = new CalculadoraService();
		Calculadora proxy = service.getCalculadoraPort();
		
		LOG.info(proxy.somar(10, 7).toString());
		LOG.info(proxy.subtrair(10, 7).toString());
	}
}
