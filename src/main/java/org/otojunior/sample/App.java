package org.otojunior.sample;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Triple;
import org.otojunior.sample.datasource.JRRandomSampleDatasource;
import org.otojunior.sample.decorator.JRDataSourceDecorator;
import org.otojunior.sample.mock.SampleMockGenerator;
import org.otojunior.sample.ui.SampleMainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRSwapFile;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	private static final int MAX = 100000;
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws JRException 
	 */
	public static void main(String[] args) throws JRException {
		JRDataSource dataSource = new JRRandomSampleDatasource(MAX);
		JRDataSourceDecorator dataSourceDecorated = new JRDataSourceDecorator(dataSource, MAX);

		JasperReport jasperSubReport = compileReport("subreport.jrxml");
		JasperReport jasperReport = compileReport("template.jrxml");
		
		// virtualizer: (para testar: -Xmx32m)
		JRSwapFile swapFile = new JRSwapFile(System.getProperty("java.io.tmpdir"), 1024, 500);
		JRSwapFileVirtualizer virtualizer = new JRSwapFileVirtualizer(50, swapFile, true);
				
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("titulo", "Relatório de Teste");
		parameters.put("layoutSubReport", jasperSubReport);
		//parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
		
		new SampleMainFrame(dataSourceDecorated).setVisible(true);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(
			jasperReport, 
			parameters, 
			dataSourceDecorated);
		
		new JasperViewer(jasperPrint).setVisible(true);
	}
	
	/**
	 * 
	 * @param report
	 * @return
	 * @throws JRException
	 */
	public static JasperReport compileReport(String report) throws JRException {
		InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(report);
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		return jasperReport;
	}
}
