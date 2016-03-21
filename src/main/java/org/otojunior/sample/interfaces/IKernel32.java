/**
 * 
 */
package org.otojunior.sample.interfaces;

import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 * @author 01456231650
 *
 */
public interface IKernel32 extends StdCallLibrary {
	IKernel32 INSTANCE = (IKernel32)Native.loadLibrary("kernel32", IKernel32.class);
	boolean Beep(int frequency, int duration);
	boolean Sleep(int miliseconds);
	boolean GetComputerNameW(char[] lpBuffer, IntByReference lpnSize);
	boolean GetComputerNameW(String lpBuffer, IntByReference lpnSize);
}
