package org.otojunior.sample;

import static org.junit.Assert.*;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main App test class.
 * @author [Author name]
 */
public class AppTest {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

	/**
	 * {@inheritDoc}
	 */
	@Before
	public void setUp() throws Exception {
		LOG.trace("Test setup");
	}

	/**
	 * {@inheritDoc}
	 */
	@After
	public void tearDown() throws Exception {
		LOG.trace("Test teardown");
	}

	/**
	 * Main method test.
	 */
	@Test
	public void testMain() {
		BeepTest.main(ArrayUtils.EMPTY_STRING_ARRAY);
	}
}
