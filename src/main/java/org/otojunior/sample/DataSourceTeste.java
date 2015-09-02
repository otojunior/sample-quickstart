/**
 * 
 */
package org.otojunior.sample;

import java.util.Collection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author 01456231650
 *
 */
public class DataSourceTeste extends JRBeanCollectionDataSource {
	/**
	 * 
	 * @param beanCollection
	 */
	public DataSourceTeste(Collection<?> beanCollection) {
		super(beanCollection);
	}
	
	@Override
	public Object getFieldValue(JRField field) throws JRException {
		if ("datasourceSubReport".equals(field.getName())) {
			return this;
		}
		return super.getFieldValue(field);
	}

}
