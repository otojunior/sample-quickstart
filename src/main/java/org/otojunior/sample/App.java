package org.otojunior.sample;

import javax.swing.JOptionPane;

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
	 */
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Latitude e Longitude Decimais (Google Maps)");
		
		CalculadoraGraus calc = new CalculadoraGraus();
		calc.toGraus(input);
	}
}
