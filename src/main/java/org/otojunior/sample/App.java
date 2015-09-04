package org.otojunior.sample;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Triple;
import org.otojunior.sample.decorator.JRDataSourceDecorator;
import org.otojunior.sample.mock.SampleMockGenerator;
import org.otojunior.sample.ui.SampleMainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws JRException 
	 */
	public static void main(String[] args) throws JRException {
		Collection<Triple<String, Double, Double>> lst = SampleMockGenerator.create(100000);
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(lst);
		JRDataSourceDecorator dataSourceDecorated = new JRDataSourceDecorator(dataSource, lst.size());

		JasperReport jasperSubReport = compileReport("subreport.jrxml");
		JasperReport jasperReport = compileReport("template.jrxml");
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("titulo", "Relatório de Teste");
		parameters.put("layoutSubReport", jasperSubReport);
		
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
