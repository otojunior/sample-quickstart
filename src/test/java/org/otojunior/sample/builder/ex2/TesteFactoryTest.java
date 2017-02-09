package org.otojunior.sample.builder.ex2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author 01456231650
 *
 */
public class TesteFactoryTest {
	/**
	 * 
	 */
	@Test
	public final void testBuilder() {
		Teste teste = TesteFactory.builder().
			um("uno").
			dois(4).
			tres(6.0).
			build();
		assertEquals("Teste(um=uno, dois=4, tres=6.0)", teste.toString());
	}
}
