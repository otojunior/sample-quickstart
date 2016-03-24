/**
 * 
 */
package org.otojunior.sample.componentes;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author 01456231650
 *
 */
public abstract class AbstractSLabelComposite extends JComponent {
	private static final long serialVersionUID = 3865414825979437960L;
	private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 5);
	
	protected JLabel label;
	
	/**
	 * Construtor alternativo.
	 * @param text
	 * @param changeListener
	 */
	public AbstractSLabelComposite(String text) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setBorder(EMPTY_BORDER);
		this.setFocusable(false);
		this.setOpaque(false);
		
		this.label = new JLabel(text);
		this.label.setBorder(EMPTY_BORDER);
		this.label.setFocusable(false);
		
		this.add(label);
	}
}
