package org.otojunior.sample;

import java.util.List;

import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class Opcao1 {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(Opcao1.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		LOG.info("sample-quickstart Application.");
		
		Configurations configs = new Configurations();
		try {
			XMLConfiguration config = configs.xml("config.xml");
			
			/*
			 * Percorrendo elementos simples
			 */
			LOG.info(config.getString("nome"));
			LOG.info(String.valueOf(config.getInt("jobs")));
			
			/*
			 * Percorrendo elementos não únicos de mesmo nível da raiz.
			 */
			List<String> lsthosts = config.getList(String.class, "host");
			for (String host : lsthosts) {
				LOG.info(host);
			}
			
			/*
			 * Percorrendo elementos não únicos de nível diferente da raiz.
			 */
			List<HierarchicalConfiguration<ImmutableNode>> configserver = config.configurationsAt("server");
			for (HierarchicalConfiguration<ImmutableNode> configip : configserver) {
				LOG.info("IPs do servidor: " + configserver.indexOf(configip));
				List<String> ips = configip.getList(String.class, "ip");
				for (String ip : ips) {
					LOG.info(ip);
				}
			}
		} catch (ConfigurationException e) {
		    LOG.error(e.getMessage(), e);
		}
	}
}
