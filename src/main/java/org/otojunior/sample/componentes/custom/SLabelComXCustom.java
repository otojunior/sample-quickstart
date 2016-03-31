/**
 * 
 */
package org.otojunior.sample.componentes.custom;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTabbedPane;

import org.otojunior.sample.componentes.SLabelComX;

/**
 * @author 01456231650
 *
 */
public class SLabelComXCustom extends SLabelComX {
	private static final long serialVersionUID = -1566478420899554650L;

	public SLabelComXCustom(String text, JTabbedPane tabbedPane, Component componente) {
		super(text, tabbedPane, componente);
		
		Font font = label.getFont();
		font = font.deriveFont(Font.BOLD);
		font = font.deriveFont(font.getSize()-1);
		label.setFont(font);
	}


}
