/**
 * 
 */
package org.otojunior.sample.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.otojunior.sample.decorator.JRDataSourceDecorator;

/**
 * Sample Main UI Frame
 * @author Oto Junior
 */
public class SampleMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton cancelBtn;
	private JPanel southPanel;
	private JProgressBar progress;
	
	private JRDataSourceDecorator dataSourceDecorator; 

	/**
	 * Default constructor.
	 * @param dataSourceDecorator DataSource decorator.
	 */
	public SampleMainFrame(JRDataSourceDecorator dataSourceDecorator) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 100);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocation(300, 300);
		
		this.dataSourceDecorator = dataSourceDecorator;
		
		cancelBtn = new JButton("Cancelar");
		southPanel = new JPanel();
		progress = new JProgressBar(dataSourceDecorator.getModel());
		
		addComponents();
		addListeners();
	}

	/**
	 * Add Listeners.
	 */
	private void addListeners() {
		cancelBtn.addActionListener(e -> dataSourceDecorator.cancelOperation());
	}

	/**
	 * Add components.
	 */
	private void addComponents() {
		this.southPanel.add(cancelBtn);
		this.add(progress, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
	}
}
