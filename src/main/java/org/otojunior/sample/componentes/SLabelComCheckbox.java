/**
 * 
 */
package org.otojunior.sample.componentes;

import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;

/**
 * @author 01456231650
 *
 */
public class SLabelComCheckbox extends AbstractSLabelComposite {
	private static final long serialVersionUID = 3865414825979437960L;
	private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);
	
	private JCheckBox checkbox;
	
	/**
	 * Construtor padrão.
	 * @param text
	 */
	public SLabelComCheckbox(String text) {
		this(text, null);
	}
	
	/**
	 * Construtor alternativo.
	 * @param text
	 * @param changeListener
	 */
	public SLabelComCheckbox(String text, ChangeListener changeListener) {
		super(text);
		
		criarCheckbox();
		
		this.addCheckChangeListener(changeListener);
		this.add(checkbox);
	}

	/**
	 * 
	 * @param checkChangeListener
	 */
	public void addCheckChangeListener(ChangeListener checkChangeListener) {
		if (checkChangeListener != null) {
			this.checkbox.addChangeListener(checkChangeListener);
		}
	}

	/**
	 * 
	 */
	private void criarCheckbox() {
		this.checkbox = new JCheckBox();
		this.checkbox.setBorderPainted(false);
		this.checkbox.setBorderPaintedFlat(false);
		this.checkbox.setFocusPainted(false);
		this.checkbox.setContentAreaFilled(false);
		this.checkbox.setMargin(EMPTY_INSETS);
	}
}
