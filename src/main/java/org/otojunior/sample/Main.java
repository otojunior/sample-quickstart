/**
 * 
 */
package org.otojunior.sample;

import javax.naming.spi.DirStateFactory.Result;

import org.otojunior.sample.dao.ApacheDSDao;
import org.otojunior.sample.dao.IDao;
import org.otojunior.sample.dao.JNDIDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class.
 * @author Oto Junior (otojunior@gmail.com)
 */
public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	/**
	 * Main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		print("##### JNDIDao #####", new JNDIDao());
		print("##### ApacheDSDao #####", new ApacheDSDao());
	}

	/**
	 * Print the result.
	 * @param desc Description concrete class.
	 * @param dao {@link IDao}
	 */
	private static void print(String desc, IDao dao) {
		LOG.info(desc);

		String[] result = dao.findUserByUid("otojunior");
		LOG.info("uid: " + result[0]);
		LOG.info("userPassword: " + result[1]);
		
		result = dao.findRolesByUid("otojunior");
		for (String role : result) {
			LOG.info("role: " + role);
		}
	}
}
