/**
 * 
 */
package org.otojunior.sample.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

/**
 * @author 01456231650
 *
 */
public class SLabelComX extends AbstractSLabelComposite {
	private static final long serialVersionUID = 3865414825979437960L;
	private static final Insets EMPTY_INSETS = new Insets(0, 5, 0, 5);
	
	private JButton botao;
	
	/**
	 * Construtor padrão.
	 * @param text
	 */
	public SLabelComX(String text) {
		this(text, null);
	}
	
	/**
	 * Construtor alternativo.
	 * @param text
	 * @param botaoActionListener
	 */
	public SLabelComX(String text, ActionListener botaoActionListener) {
		super(text);
		
		criarBotao();
		
		this.addBotaoActionListener(botaoActionListener);
		this.add(botao);
	}

	/**
	 * Construtor alternativo.
	 * @param text
	 * @param listenerBotao
	 */
	public SLabelComX(String text, final JTabbedPane tabbedPane, final Component componente) {
		super(text);
		
		criarBotao();
		
		this.botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(componente);
			}
		});
				
		this.add(botao);
	}

	/**
	 * 
	 * @param listener
	 */
	public void addBotaoActionListener(ActionListener listener) {
		if (listener != null) {
			this.botao.addActionListener(listener);
		}
	}

	/**
	 * 
	 */
	private void criarBotao() {
		this.botao = new JButton("x");
		this.botao.setBorderPainted(false);
		this.botao.setFocusPainted(false);
		this.botao.setContentAreaFilled(true);
		this.botao.setMargin(EMPTY_INSETS);
		this.botao.setFont(this.botao.getFont().deriveFont(Font.BOLD));
		this.botao.setForeground(Color.RED);
	}
}
