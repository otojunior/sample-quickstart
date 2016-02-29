/**
 * 
 */
package org.otojunior.sample.datasource;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * @author 01456231650
 *
 */
public class JRRandomSampleDatasource implements JRDataSource {
	private int count;
	private int max;

	/**
	 * 
	 * @param max
	 */
	public JRRandomSampleDatasource(int max) {
		this.count = -1;
		this.max = max;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean next() throws JRException {
		if (count < max) {
			count++;
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		Object retorno = null;
		if ("left".equals(jrField.getName())) {
			return "Elemento " + count;
		} else {
			retorno = Double.valueOf(Math.random());
		}
		return retorno;
	}
}
