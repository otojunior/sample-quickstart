package org.otojunior.sample.cxf.app;

import org.otojunior.sample.cxf.server.SampleServer;

/**
 * 
 * @author 01456231650
 *
 */
public class App {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Aplicação iniciada...");
		new Thread(new SampleServer()).start();
		
		
	}
}
