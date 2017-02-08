/**
 * 
 */
package org.otojunior.sample.opcao2.config;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @author 01456231650
 *
 */
@XStreamAlias("configuration")
public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String jobs;
	
	@XStreamImplicit(itemFieldName="host")
	private List<String> host;
	
	@XStreamImplicit(itemFieldName="server")
	private List<Server> server;

	/**
	 * @param nome
	 * @param jobs
	 * @param host
	 * @param server
	 */
	public Configuration(String nome, String jobs, List<String> host, List<Server> server) {
		this.nome = nome;
		this.jobs = jobs;
		this.host = host;
		this.server = server;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the jobs
	 */
	public String getJobs() {
		return jobs;
	}
	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	/**
	 * @return the host
	 */
	public List<String> getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(List<String> host) {
		this.host = host;
	}
	/**
	 * @return the server
	 */
	public List<Server> getServer() {
		return server;
	}
	/**
	 * @param server the server to set
	 */
	public void setServer(List<Server> server) {
		this.server = server;
	}
}
