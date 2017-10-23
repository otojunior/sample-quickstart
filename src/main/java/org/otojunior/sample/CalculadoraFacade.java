/**
 * 
 */
package org.otojunior.sample;

/**
 * @author 01456231650
 *
 */
public class CalculadoraFacade {
	private ICalculadoraService service;
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Integer somar(Integer a, Integer b) {
		return service.somar(a, b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Integer subtrair (Integer a, Integer b) {
		return service.subtrair(a, b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Integer multiplicar(Integer a, Integer b) {
		return service.multiplicar(a, b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Double dividir(Integer a, Integer b) {
		return service.dividir(a, b);
	}
}
