/**
 * 
 */
package org.otojunior.sample.cxf.entidade;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author 01456231650
 *
 */
@WebService
public class Calculadora implements ICalculadora {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Override
	@WebMethod
	public Integer somar(
			@WebParam(name="numeroA") Integer numero1, 
			@WebParam(name="numeroB") Integer numero2) {
		Integer result = Integer.valueOf(
			numero1.intValue() + 
			numero2.intValue());
		return result;
	}

	/* (non-Javadoc)
	 * @see org.otojunior.sample.cxf.entidade.ICalculadora#subtrair(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@WebMethod
	public Integer subtrair(
			@WebParam(name="numeroA") Integer numero1, 
			@WebParam(name="numeroB") Integer numero2) {
		Integer result = Integer.valueOf(
			numero1.intValue() - 
			numero2.intValue());
		return result;
	}

	/* (non-Javadoc)
	 * @see org.otojunior.sample.cxf.entidade.ICalculadora#multiplicar(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@WebMethod
	public Integer multiplicar(
			@WebParam(name="numeroA") Integer numero1, 
			@WebParam(name="numeroB") Integer numero2) {
		Integer result = Integer.valueOf(
			numero1.intValue() * 
			numero2.intValue());
		return result;
	}

	/*
	 * Por padrão, uma classe anotada com @WebService, 
	 * os métodos serão expostos com @WebMethod
	 * automaticamente.
	 */
	@Override
	public Double dividir(Integer numero1, Integer numero2) {
		double double1 = numero1.doubleValue();
		double double2 = numero2.doubleValue();
		Double result = Double.valueOf(double1 / double2);
		return result;
	}
}
