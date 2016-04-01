/**
 * 
 */
package org.otojunior.sample.mapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jna.FunctionMapper;
import com.sun.jna.NativeLibrary;

/**
 * @author 01456231650
 *
 */
public final class NetBeansLibMapper implements FunctionMapper {
	private static final Logger LOG = LoggerFactory.getLogger(NetBeansLibMapper.class);
	private static final Map<String, String> MAPPINGS = new HashMap<>();
	
	static {
		MAPPINGS.put("dif", "_ZN11ClasseTeste3difEii");
		MAPPINGS.put("soma", "_ZN11ClasseTeste4somaEii");
	}
	
	private NetBeansLibMapper() { }
	
	public static final NetBeansLibMapper INSTANCE = new NetBeansLibMapper();
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFunctionName(NativeLibrary library, Method method) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("method: " + method.getName());
		}
		return MAPPINGS.get(method.getName());
	}
}
