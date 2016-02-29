/**
 * 
 */
package org.otojunior.sample.datasource;

import org.apache.commons.lang3.tuple.Triple;

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
		this.count = 0;
		this.max = max;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean next() throws JRException {
		if (count <= max) {
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
		return Triple.of(
			"Elemento " + count, 
			Double.valueOf(Math.random()), 
			Double.valueOf(Math.random()));
	}
}
