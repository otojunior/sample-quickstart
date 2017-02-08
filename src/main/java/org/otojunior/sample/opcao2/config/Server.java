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
@XStreamAlias("server")
public class Server implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XStreamImplicit(itemFieldName="ip")
	public List<String> ip;

	/**
	 * @param ip
	 */
	public Server(List<String> ip) {
		this.ip = ip;
	}


	/**
	 * @return the ip
	 */
	public List<String> getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(List<String> ip) {
		this.ip = ip;
	}
	
	
}
