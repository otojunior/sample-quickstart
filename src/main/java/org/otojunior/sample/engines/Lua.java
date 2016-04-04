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
public interface Lua {
	/**
	 * Lua Language engine.
	 */
	ScriptEngine ENGINE = new ScriptEngineManager().getEngineByName("lua");
}
