/**
 * 
 */
package org.otojunior.sample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.otojunior.sample.componentes.SLabelComCheckbox;
import org.otojunior.sample.componentes.SLabelComX;
import org.otojunior.sample.componentes.custom.SLabelComXCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class SamplePanelGrid extends JPanel {
	private static final long serialVersionUID = 5764372855443419063L;
	private static final int ITENS_POR_COLUNA = 20;
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(SamplePanelGrid.class);
	
	/**
	 * 
	 */
	public SamplePanelGrid() {
		this.setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		
		JPanel abaA = criarAba(10);
		JPanel abaB = criarAba(25);
		JPanel abaC = criarAba(35);
		
		tabbedPane.add(abaA);
		tabbedPane.add(abaB);
		tabbedPane.add(abaC);
		
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(abaA), new SLabelComCheckbox("Aba de Teste 1"));
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(abaB), new SLabelComX("Aba de Teste 2", tabbedPane, abaB));
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(abaC), new SLabelComXCustom("Aba de Teste 3", tabbedPane, abaC));
		
		
		this.add(tabbedPane, BorderLayout.CENTER);
	}
	
	public JPanel criarAba(final int totalItens) {
		JPanel aba = new JPanel();
		aba.setLayout(new BorderLayout());
		aba.setBackground(Color.WHITE);
		
		int numeroLinhas = ITENS_POR_COLUNA;
		int numeroColunas = (int)Math.ceil(((double)totalItens/ITENS_POR_COLUNA));

		aba.setLayout(new GridLayout(numeroLinhas,numeroColunas));
		aba.setBackground(Color.WHITE);
		
		JLabel x = new JLabel("teste");
		Font font = x.getFont();
		font = font.deriveFont(font.getSize()*2);
		font = font.deriveFont(Font.BOLD, (float)(font.getSize()-0.5));
		x.setFont(font);
		
		aba.add(x);
		
		for (int i = 0; i < totalItens ; i++) {
			JCheckBox checkbox = new JCheckBox("Checkbox de teste do GridBagLayout: identificador do componente: " + i);
			checkbox.setBackground(Color.WHITE);
			checkbox.setSelected(true);
			aba.add(checkbox);
		}
		return aba;
	}
}
