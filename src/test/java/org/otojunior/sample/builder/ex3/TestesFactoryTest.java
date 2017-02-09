package org.otojunior.sample.builder.ex3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author 01456231650
 *
 */
public class TestesFactoryTest {
	/**
	 * 
	 */
	@Test
	public final void testTipo1Builder() {
		TesteTipo1 teste = TestesFactory.tipo1Builder().
			um("aaaaa").
			dois(10).
			tres(20.0).
			build();
		assertEquals("TesteTipo1(um=aaaaa, dois=10, tres=20.0)", teste.toString());
	}

	/**
	 * 
	 */
	@Test
	public final void testTipo2Builder() {
		TesteTipo2 teste = TestesFactory.tipo2Builder().
			um("bbbbb").
			dois(100).
			tres(200.0).
			build();
		assertEquals("TesteTipo2(one=bbbbb, two=100, three=200.0)", teste.toString());
	}
}
