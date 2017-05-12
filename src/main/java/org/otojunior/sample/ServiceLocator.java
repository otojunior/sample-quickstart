/**
 * 
 */
package org.otojunior.sample;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.otojunior.sample.parametros.JdbcParametros;

/**
 * @author 01456231650
 *
 */
public class ServiceLocator {
	private static DataSource datasource;
	
	/**
	 * Gets {@link DataSource}
	 * @return
	 */
	public static DataSource getDataSource() {
		if (datasource == null) {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName(JdbcParametros.DRIVER);
			ds.setUrl(JdbcParametros.URL);
			ds.setUsername(JdbcParametros.USER);
			ds.setPassword(JdbcParametros.PASSWORD);
			ds.setMinIdle(5);
			ds.setMaxIdle(10);
			ds.setMaxTotal(10);
			ds.setMaxOpenPreparedStatements(50);
			datasource = ds;
		}
		return datasource;
	}
}
