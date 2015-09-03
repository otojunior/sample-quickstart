/**
 * 
 */
package org.otojunior.sample.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Triple;

/**
 * Sample mock generator.
 * @author Oto Junior
 */
public class SampleMockGenerator {
	/**
	 * Create mock data. 
	 * @param count quantity od records.
	 * @return
	 */
	public static Collection<Triple<String, Double, Double>> create(final int count) {
		Collection<Triple<String, Double, Double>> lst = new ArrayList<>();
		
		lst.add(Triple.of(
			StringUtils.EMPTY, 
			NumberUtils.DOUBLE_ZERO, 
			NumberUtils.DOUBLE_ZERO));
		
		for (int i = 1; i <= count; i++) {
			lst.add(Triple.of(
				"Elemento " + i, 
				Double.valueOf(Math.random()), 
				Double.valueOf(Math.random())));
		}
		return lst;
	}
}
