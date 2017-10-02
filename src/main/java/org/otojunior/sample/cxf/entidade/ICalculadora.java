package org.otojunior.sample.cxf.entidade;

import java.io.Serializable;

/**
 * 
 * @author 01456231650
 *
 */
public interface ICalculadora extends Serializable {
	public Integer somar(Integer numero1, Integer numero2);
	public Integer subtrair(Integer numero1, Integer numero2);
	public Integer multiplicar(Integer numero1, Integer numero2);
	public Double dividir(Integer numero1, Integer numero2);
}
