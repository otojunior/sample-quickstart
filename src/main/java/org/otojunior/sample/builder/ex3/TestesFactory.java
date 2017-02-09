package org.otojunior.sample.builder.ex3;

import lombok.Builder;

/**
 * 
 * @author 01456231650
 *
 */
public class TestesFactory {
	/**
	 * 
	 * @param um
	 * @param dois
	 * @param tres
	 * @return
	 */
	@Builder(builderMethodName="tipo1Builder")
	private static TesteTipo1 getTipo1(String um, Integer dois, Double tres) {
		final TesteTipo1 teste = new TesteTipo1();
		teste.setUm(um);
		teste.setDois(dois);
		teste.setTres(tres);
		return teste;
	}
	
	/**
	 * 
	 * @param um
	 * @param dois
	 * @param tres
	 * @return
	 */
	@Builder(builderMethodName="tipo2Builder")
	private static TesteTipo2 getTipo2(String um, Integer dois, Double tres) {
		final TesteTipo2 teste = new TesteTipo2();
		teste.setOne(um);
		teste.setTwo(dois);
		teste.setThree(tres);
		return teste;
	}
}
