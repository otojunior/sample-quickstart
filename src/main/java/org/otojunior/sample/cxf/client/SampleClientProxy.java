/**
 * 
 */
package org.otojunior.sample.cxf.client;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.otojunior.sample.cxf.entidade.ICalculadora;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class SampleClientProxy {
	private static final Logger LOG = LoggerFactory.getLogger(SampleClientProxy.class);
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		factory.setAddress("http://localhost:9000/calculadoraws");
		factory.setServiceClass(ICalculadora.class);
		ICalculadora proxy = (ICalculadora)factory.create();
		
		LOG.info(proxy.somar(10, 7).toString());
	}
}
