package org.otojunior.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		Server server = null;
		try {
			server = Server.createTcpServer("-tcpPort", "9123", "-tcpAllowOthers");
			server.start();
			LOG.info(server.getStatus());
			
			BasicDataSource bds = (BasicDataSource)ServiceLocator.getDataSource();
			
			logconnections(bds);
			
			Connection conn1 = bds.getConnection();
			Connection conn2 = bds.getConnection();
			Connection conn3 = bds.getConnection();
			
			logconnections(bds);
			
			conn1.close();
			conn2.close();
						
			logconnections(bds);
			
			Connection conn4 = bds.getConnection();
			
			logconnections(bds);
			
			conn3.close();
			conn4.close();
		} finally {
			Server.shutdownTcpServer("tcp://localhost:9123", "", true, false);
		}
	}
	
	/**
	 * Log connections
	 * @param bds {@link BasicDataSource}
	 */
	public static void logconnections(BasicDataSource basicDataSource) {
		StringBuilder str = new StringBuilder("Active: ");
		str.append(basicDataSource.getNumActive()).
			append(" - Idle: ").
			append(basicDataSource.getNumIdle());
		LOG.info(str.toString());
	}
}
