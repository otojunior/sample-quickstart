/**
 * 
 */
package org.otojunior.sample.engines;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Lua Language interface.
 * @author Oto Junior
 */
public interface LuaJ {
	/**
	 * Lua Language engine.
	 */
	ScriptEngine ENGINE = new ScriptEngineManager().getEngineByName("luaj");
}
