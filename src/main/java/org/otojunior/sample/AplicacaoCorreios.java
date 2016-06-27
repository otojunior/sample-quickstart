package org.otojunior.sample;

import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.otojunior.sample.soap.AtendeCliente;
import org.otojunior.sample.soap.AtendeClienteService;
import org.otojunior.sample.soap.EnderecoERP;
import org.otojunior.sample.soap.SQLException_Exception;
import org.otojunior.sample.soap.SigepClienteException;

/**
 * <p>AplicacaoCorreios class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
public class AplicacaoCorreios {
	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws Exception {
		AtendeClienteService service = new AtendeClienteService();
		AtendeCliente port = service.getAtendeClientePort();
		
		try {
			consultarCEP(port);
			consultarSRO(port);
		} catch (SQLException_Exception | SigepClienteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param port
	 * @throws SigepClienteException
	 * @throws ParserConfigurationException 
	 */
	private static void consultarSRO(AtendeCliente port) throws Exception {
		List<String> lst = Arrays.asList(
			"DU511327170BR", 
			"DU511279868BR", 
			"DM788604881BR");		
		String sro = port.consultaSRO(lst, "L", "T", "ECT", "SRO");
		System.out.println(sro);
	}

	/**
	 * @param port
	 * @throws SQLException_Exception
	 * @throws SigepClienteException
	 */
	private static void consultarCEP(AtendeCliente port) throws SQLException_Exception, SigepClienteException {
		EnderecoERP endereco = port.consultaCEP("30730440");
					
		StringBuilder str = new StringBuilder();
		str.append(endereco.getEnd()).append("\n").
			append(endereco.getBairro()).append("\n").
			append(endereco.getCidade()).append("\n").
			append(endereco.getUf()).append("\n");
		System.out.println(str.toString());
	}
}
