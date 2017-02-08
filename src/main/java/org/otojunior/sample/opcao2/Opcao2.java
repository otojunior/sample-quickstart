package org.otojunior.sample.opcao2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.otojunior.sample.opcao2.config.Configuration;
import org.otojunior.sample.opcao2.config.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * @author 01456231650
 *
 */
public class Opcao2 {
	private static final Logger LOG = LoggerFactory.getLogger(Opcao2.class);
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		XStream xstream = new XStream(new DomDriver());
		
		xstream.processAnnotations(new Class[] {
			Configuration.class, 
			Server.class});
		
		//saida
		Server s1 = new Server(Arrays.asList("192.168.0.1", "192.168.0.2", "192.168.0.3"));
		Server s2 = new Server(Arrays.asList("192.168.0.4", "192.168.0.5", "192.168.0.6"));
		List<Server> servers = Arrays.asList(s1, s2);
		
		List<String> hosts = Arrays.asList("host_ex1", "host_ex2");
		
		Configuration conf = new Configuration("poc", "15", hosts, servers);
		
		PrintWriter writer = new PrintWriter("src/main/resources/saida.xml");
		xstream.toXML(conf, writer);
		writer.close();
		
		
		// entrada
		InputStream in = Opcao2.class.
			getClassLoader().
			getResourceAsStream("config.xml");
		
		Configuration configuration = null;
		if (in != null) {
			configuration = (Configuration)xstream.fromXML(in);
			in.close();
		} else {
			LOG.error("Arquivo de configuração não encontrado");
		}
		
		LOG.info(configuration.toString());
	}
}
