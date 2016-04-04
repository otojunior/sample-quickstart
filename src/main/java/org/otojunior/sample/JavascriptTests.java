package org.otojunior.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.script.ScriptException;

import org.otojunior.sample.engines.Javascript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class JavascriptTests {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(JavascriptTests.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws ScriptException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ScriptException, IOException {
		Reader reader = new FileReader("target/classes/teste.js");
		
		Javascript.ENGINE.eval("print('script teste')");
		Javascript.ENGINE.eval(reader);
		Javascript.ENGINE.eval("print(soma(2,3))");
		Object o = Javascript.ENGINE.eval("soma(4,3)");
		
		LOG.info(Boolean.valueOf(o == null).toString());
		if (o != null)
			LOG.info(o.toString());

		reader.close();
	}
}
