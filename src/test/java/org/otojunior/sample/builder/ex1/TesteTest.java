/**
 * 
 */
package org.otojunior.sample.builder.ex1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 01456231650
 *
 */
public class TesteTest {
	/**
	 * Test method for {@link org.otojunior.sample.builder.ex1.Teste#builder()}.
	 */
	@Test
	public final void testBuilder() {
		Teste teste = Teste.builder().
			um("one").
			dois(2).
			tres(3.0).
			build();
		assertEquals("Teste(um=one, dois=2, tres=3.0)", teste.toString());
	}
}
