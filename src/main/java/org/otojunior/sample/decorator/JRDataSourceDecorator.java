/**
 * 
 */
package org.otojunior.sample.decorator;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Decorator.
 * @author Oto Junior
 */
public class JRDataSourceDecorator implements JRDataSource {
	private JRDataSource decorated;
	private BoundedRangeModel model;
	private boolean inOperation = true;
	
	/**
	 * 
	 * @param decorated JRDataSource decorado.
	 * @param max Valor máximo do contador (Para o progress Bar).
	 */
	public JRDataSourceDecorator(JRDataSource decorated, int max) {
		this.decorated = decorated;
		this.model = new DefaultBoundedRangeModel(0, 0, 0, max);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean next() throws JRException {
		model.setValue(model.getValue()+1);			// implementação da barra de progresso.

		/*
		 * Atraso proposital para ser possível a visualização
		 * da barra de progresso. 
		 */
		//try { Thread.sleep(1); } 					
		//catch (InterruptedException e) { e.printStackTrace(); }
		
		return inOperation && decorated.next();
	}

	/**
	 * 
	 */
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		return decorated.getFieldValue(jrField);
	}
	
	/**
	 * 
	 * @return
	 */
	public BoundedRangeModel getModel() {
		return this.model;
	}

	/**
	 * 
	 */
	public void cancelOperation() {
		inOperation = false;
	}
}
