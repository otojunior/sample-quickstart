/**
 * 
 */
package org.otojunior.sample;

import org.otojunior.sample.dao.JNDIDao;

/**
 * Main class.
 * @author Oto Junior (otojunior@gmail.com)
 */
public class Main {
	public static void main(String[] args) {
		JNDIDao dao = new JNDIDao();
		dao.findUserByUid("otojunior");
		dao.findRolesByUid("otojunior");
	}
}
