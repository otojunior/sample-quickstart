/**
 * 
 */
package org.otojunior.sample.interfaces;

import java.util.Collections;

import org.otojunior.sample.mapping.NetBeansLibMapper;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author 01456231650
 *
 */
public interface INetBeansLib extends Library {
	INetBeansLib INSTANCE = (INetBeansLib)Native.loadLibrary(
		"libdinamica01", 
		INetBeansLib.class, 
		Collections.singletonMap(Library.OPTION_FUNCTION_MAPPER, NetBeansLibMapper.INSTANCE)
	);
	
	int soma(int x, int y);
	int dif(int x, int y);
}
