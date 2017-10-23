package org.otojunior.sample;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

/**
 * Com as anotações do Mockito, fica mais fácil injetar mocks sem o uso da 
 * classe Whitebox do PoweMock. 
 * @author 01456231650
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculadoraFacadeInjectTest {
	/*
	 * Mocks
	 */
	@Mock private ICalculadoraService mock;
	
	/*
	 * Classes a serem testadas 
	 */
	@InjectMocks private CalculadoraFacade facade;
	
	
	/**
	 * 
	 */
	@Before
	public void before() {
		/*
		 * O método abaixo inicializa o motor de anotações para que possa
		 * ser usada as anotações @Mock e @InjectMocks.
		 * Alternativamente, pode ser usado a anotação de classe
		 * @RunWith(MockitoJUnitRunner.class) como mostrado neste exemplo
		 */
		//MockitoAnnotations.initMocks(this);
		
		facade = new CalculadoraFacade();
	}
	
	/**
	 * 
	 */
	@After
	public void after() {
		facade = null;
	}
	
	/**
	 * 
	 */
	@Test
	public void testSomar() {
		Mockito.when(mock.somar(1, 2)).thenReturn(3);
		Mockito.when(mock.somar(3, 5)).thenReturn(8);
		Whitebox.setInternalState(facade, ICalculadoraService.class, mock);
		assertEquals(Integer.valueOf(3), facade.somar(1, 2));
		assertEquals(Integer.valueOf(8), facade.somar(3, 5));
	}

	/**
	 * 
	 */
	@Test
	public void testSubtrair() {
		Mockito.when(mock.subtrair(10, 8)).thenReturn(2);
		Mockito.when(mock.subtrair(8, 4)).thenReturn(4);
		Whitebox.setInternalState(facade, ICalculadoraService.class, mock);
		assertEquals(Integer.valueOf(2), facade.subtrair(10, 8));
		assertEquals(Integer.valueOf(4), facade.subtrair(8, 4));
	}

	/**
	 * 
	 */
	@Test
	public void testMultiplicar() {
		Mockito.when(mock.multiplicar(10, 8)).thenReturn(80);
		Mockito.when(mock.multiplicar(8, 4)).thenReturn(32);
		Whitebox.setInternalState(facade, ICalculadoraService.class, mock);
		assertEquals(Integer.valueOf(80), facade.multiplicar(10, 8));
		assertEquals(Integer.valueOf(32), facade.multiplicar(8, 4));
	}

	/**
	 * 
	 */
	@Test
	public void testDividir() {
		Mockito.when(mock.dividir(15, 5)).thenReturn(3d);
		Mockito.when(mock.dividir(8, 4)).thenReturn(2d);
		Whitebox.setInternalState(facade, ICalculadoraService.class, mock);
		assertEquals(Double.valueOf(3d), facade.dividir(15, 5));
		assertEquals(Double.valueOf(2d), facade.dividir(8, 4));
	}
}
