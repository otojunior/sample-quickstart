/**
 * 
 */
package org.otojunior.sample.ui;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Janela Principal
 * @author Oto Junior
 */
public class JanelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(JanelaPrincipal.class);
	
	/**
	 * Construtor padrão.
	 */
	public JanelaPrincipal() {
		this.setSize(200, 100);
		this.setLocation(500,  500);
		this.setResizable(false);
		this.setTitle("Janela Principal - Teste IzPack");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(e -> {
			StringBuilder buffer = new StringBuilder();
			
			try {
				for (int i = 1; i <= 2; i++) {
					String arquivo = String.format("recursos/tabelas/tabela%d.txt", i);
					RandomAccessFile r = new RandomAccessFile(arquivo, "r");
					String linha = r.readLine();
					while (linha != null) {
						buffer.
							append(linha).
							append(SystemUtils.LINE_SEPARATOR);
						linha = r.readLine();
					}
					r.close();
				}
			} catch (IOException ioe) {
				LOG.error("I/O Error", e);
			}
			
			JOptionPane.showMessageDialog(
				JanelaPrincipal.this, 
				buffer.toString());
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> {
			JanelaPrincipal.this.setVisible(false);
			JanelaPrincipal.this.dispose();
			System.exit(0);
		});
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.add(btnOk);
		painelBotoes.add(btnCancelar);
		
		this.add(painelBotoes, BorderLayout.SOUTH);
		this.add(new JLabel("Teste IzPack"), BorderLayout.CENTER);
	}
}
