package org.otojunior.sample;

/**
 * 
 * @author 01456231650
 *
 */
public class CalculadoraService implements ICalculadoraService {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer somar(Integer a, Integer b) {
		return Integer.valueOf(a.intValue() + b.intValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer subtrair(Integer a, Integer b) {
		return Integer.valueOf(a.intValue() - b.intValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer multiplicar(Integer a, Integer b) {
		return Integer.valueOf(a.intValue() * b.intValue());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double dividir(Integer a, Integer b) {
		double d = Double.valueOf(a.doubleValue());
		return Double.valueOf(d / b.doubleValue());
	}
}
