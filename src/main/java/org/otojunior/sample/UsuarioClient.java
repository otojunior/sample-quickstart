package org.otojunior.sample;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.otojunior.sample.soap.IUsuarioSOAP;
import org.otojunior.sample.soap.Usuario;
import org.otojunior.sample.soap.UsuarioSOAPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class UsuarioClient {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioClient.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		LOG.info("sample-quickstart Application.");
		
		UsuarioSOAPService service = new UsuarioSOAPService();
		IUsuarioSOAP port = service.getUsuarioSOAPPort();
		
		LOG.info("Usuarios: " + toString(port.getUsuarios()));
		LOG.info("Usuario #2: " + toString(port.getUsuario(2L)));
	}
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	private static String toString(Usuario usuario) {
		return ToStringBuilder.reflectionToString(usuario, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	private static String toString(List<Usuario> usuarios) {
		StringBuilder str = new StringBuilder();
		for (Usuario usuario : usuarios)
			str.append(toString(usuario)).append(";");
		return str.toString();
	}
}

