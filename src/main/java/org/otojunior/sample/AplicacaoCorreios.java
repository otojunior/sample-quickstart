package org.otojunior.sample;

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
	 */
	public static void main(String[] args) {
		AtendeClienteService service = new AtendeClienteService();
		AtendeCliente port = service.getAtendeClientePort();
		
		try {
			EnderecoERP endereco = port.consultaCEP("31360280");
			
			StringBuilder str = new StringBuilder();
			str.append(endereco.getEnd()).append("\n").
				append(endereco.getBairro()).append("\n").
				append(endereco.getCidade()).append("\n").
				append(endereco.getUf()).append("\n");
			System.out.println(str.toString());
		} catch (SQLException_Exception | SigepClienteException e) {
			e.printStackTrace();
		}
	}
}
