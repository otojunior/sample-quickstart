/**
 * 
 */
package org.otojunior.sample;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 01456231650
 *
 */
public class SampleFrame extends JFrame {
	private static final long serialVersionUID = 4066198035944986662L;
	
	/**
	 * 
	 */
	public SampleFrame() {
		setTitle("Aplicativo de exemplo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// painel centro
		JPanel painelCentro = new SamplePanelGrid();
		
		// painel sul
		JButton btn = new JButton("Visualizar");
		btn.addActionListener(evt -> SampleFrame.this.dispose());

		JPanel painelSul = new JPanel();
		painelSul.add(btn);
		
		getContentPane().add(painelCentro, BorderLayout.CENTER);
		getContentPane().add(painelSul, BorderLayout.SOUTH);
		
	}
}
