/**
 * 
 */
package org.otojunior.sample.interfaces;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

/**
 * @author 01456231650
 *
 */
public interface IAdvApi32 extends Library {
	IAdvApi32 INSTANCE = (IAdvApi32)Native.loadLibrary("advapi32", IAdvApi32.class);
	
	boolean GetUserNameW(char[] lpBuffer, IntByReference lpnSize);
}
