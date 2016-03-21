/**
 * 
 */
package org.otojunior.sample;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class SamplePanelGrid extends JPanel {
	private static final long serialVersionUID = 5764372855443419063L;
	private static final Logger LOG = LoggerFactory.getLogger(SamplePanelGrid.class);
	
	/**
	 * 
	 */
	public SamplePanelGrid() {
		final int TOTAL_ITENS = 6;			// tamanho da lista
		final int ITENS_POR_COLUNA = 20;
		
		int numeroLinhas = ITENS_POR_COLUNA;
		int numeroColunas = (int)Math.ceil(((double)TOTAL_ITENS/ITENS_POR_COLUNA));

		setLayout(new GridLayout(numeroLinhas,numeroColunas));
		setBackground(Color.WHITE);
				
		for (int i = 0; i < TOTAL_ITENS ; i++) {
			JCheckBox checkbox = new JCheckBox("Checkbox de teste do GridBagLayout: identificador do componente: " + i);
			checkbox.setBackground(Color.WHITE);
			
			add(checkbox);
		}
	}
	
	private GridBagConstraints criarRestricoes(int gridx, int gridy, double wei) {
		return null;
		
	}
}
