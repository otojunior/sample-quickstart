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
public interface Javascript {
	/**
	 * Lua Language engine.
	 */
	ScriptEngine ENGINE = new ScriptEngineManager().getEngineByName("javascript");
}
