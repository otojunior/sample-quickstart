package org.otojunior.sample.builder.ex2;

import lombok.Builder;

/**
 * 
 * @author 01456231650
 *
 */
public class TesteFactory {
	/**
	 * 
	 * @param um
	 * @param dois
	 * @param tres
	 * @return
	 */
	@Builder
	private static Teste get(String um, Integer dois, Double tres) {
		final Teste teste = new Teste();
		teste.setUm(um);
		teste.setDois(dois);
		teste.setTres(tres);
		return teste;
	}
}
