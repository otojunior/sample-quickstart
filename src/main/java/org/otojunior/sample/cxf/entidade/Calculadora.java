/**
 * 
 */
package org.otojunior.sample.cxf.entidade;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author 01456231650
 *
 */
@WebService
public class Calculadora implements ICalculadora {

	/* (non-Javadoc)
	 * @see org.otojunior.sample.cxf.entidade.ICalculadora#somar(java.lang.Integer, java.lang.Integer)
	 */
	@WebMethod
	@Override
	public Integer somar(Integer numero1, Integer numero2) {
		Integer result = Integer.valueOf(
			numero1.intValue() + 
			numero2.intValue());
		return result;
	}

	/* (non-Javadoc)
	 * @see org.otojunior.sample.cxf.entidade.ICalculadora#subtrair(java.lang.Integer, java.lang.Integer)
	 */
	@WebMethod
	@Override
	public Integer subtrair(Integer numero1, Integer numero2) {
		Integer result = Integer.valueOf(
			numero1.intValue() - 
			numero2.intValue());
		return result;
	}

	/* (non-Javadoc)
	 * @see org.otojunior.sample.cxf.entidade.ICalculadora#multiplicar(java.lang.Integer, java.lang.Integer)
	 */
	@WebMethod
	@Override
	public Integer multiplicar(Integer numero1, Integer numero2) {
		Integer result = Integer.valueOf(
			numero1.intValue() * 
			numero2.intValue());
		return result;
	}

	/* (non-Javadoc)
	 * @see org.otojunior.sample.cxf.entidade.ICalculadora#dividir(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Double dividir(Integer numero1, Integer numero2) {
		double double1 = numero1.doubleValue();
		double double2 = numero2.doubleValue();
		Double result = Double.valueOf(double1 / double2);
		return result;
	}
}
