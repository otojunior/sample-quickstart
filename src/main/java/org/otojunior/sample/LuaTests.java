package org.otojunior.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.script.ScriptException;

import org.otojunior.sample.engines.Lua;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class LuaTests {
	/**
	 * SLF4J Logger.
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(LuaTests.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws ScriptException 
	 * @throws IOException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws ScriptException, IOException, NoSuchMethodException {
		Reader reader = new FileReader("target/classes/teste.lua");
		
		Lua.ENGINE.eval("print('script teste')");
		Lua.ENGINE.eval(reader);
		Lua.ENGINE.eval("print(soma(2,3))");
		Lua.ENGINE.eval("r = soma(4,3)");
		System.out.println(Lua.ENGINE.get("r"));
		
		reader.close();
	}
}
