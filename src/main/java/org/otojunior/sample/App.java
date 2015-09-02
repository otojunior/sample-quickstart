package org.otojunior.sample;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws JRException 
	 */
	public static void main(String[] args) throws JRException {
		Collection<Pair<String, String>> lst = new ArrayList<>();
		lst.add(new ImmutablePair<String, String>("um", "one"));
		lst.add(new ImmutablePair<String, String>("dois", "two"));
		lst.add(new ImmutablePair<String, String>("três", "three"));
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(lst);

		// --------------------------------------------
		
		InputStream inputStreamSubreport = ClassLoader.getSystemClassLoader().getResourceAsStream("subreport.jrxml");
		JasperReport jasperSubReport = JasperCompileManager.compileReport(inputStreamSubreport);
		
		// --------------------------------------------
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("titulo", "Relatório de Teste");
		parameters.put("layoutSubReport", jasperSubReport);
		
		String destFileName = "saida.pdf";
		
		InputStream inputStreamReport = ClassLoader.getSystemClassLoader().getResourceAsStream("template.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStreamReport);
		
		JasperFillManager.fillReportToFile(jasperReport, destFileName, parameters, dataSource);
	}
}
