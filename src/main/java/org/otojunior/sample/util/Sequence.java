/**
 * 
 */
package org.otojunior.sample.util;

/**
 * @author 01456231650
 *
 */
public class Sequence {
	private static int sq = 0;
	
	/**
	 * Next int
	 * @return
	 */
	public static int nextInt() {
		return ++sq;
	}
}
