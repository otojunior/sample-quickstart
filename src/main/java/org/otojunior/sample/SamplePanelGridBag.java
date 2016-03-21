/**
 * 
 */
package org.otojunior.sample;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class SamplePanelGridBag extends JPanel {
	private static final long serialVersionUID = 5764372855443419063L;
	private static final Logger LOG = LoggerFactory.getLogger(SamplePanelGridBag.class);
	
	/**
	 * 
	 */
	public SamplePanelGridBag() {
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		final int TOTAL_ITENS = 25;			// tamanho da lista
		final int ITENS_POR_COLUNA = 20;
		
		for (int i = 0, coluna = 0; i < TOTAL_ITENS; coluna++) {
			for (int linha = 0; i < TOTAL_ITENS && linha < ITENS_POR_COLUNA; linha++) {
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = coluna;
				c.gridy = linha;
				c.weightx = 100;
				c.weighty = 100;
				c.anchor = GridBagConstraints.NORTHWEST;
				
				JCheckBox checkbox = new JCheckBox("Checkbox de teste do GridBagLayout: identificador do componente: " + (i++));
				checkbox.setBackground(Color.WHITE);
				
				add(checkbox, c);
			}
		}
	}
	
	private GridBagConstraints criarRestricoes(int gridx, int gridy, double wei) {
		return null;
		
	}
}
