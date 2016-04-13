/**
 * 
 */
package org.otojunior.sample.threads.tasks;

import java.util.concurrent.Callable;

/**
 * @author 01456231650
 *
 */
public class MyCallable extends AbstractMyTask implements Callable<Integer> {
	/**
	 * Construtor padrão.
	 * @param id
	 */
	public MyCallable(int id) {
		super(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer call() throws Exception {
		System.out.println("MyCallable execution id: " + id);
		delay(); 
		return id;
	}
}
