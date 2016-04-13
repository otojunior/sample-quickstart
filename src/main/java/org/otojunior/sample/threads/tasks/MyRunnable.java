/**
 * 
 */
package org.otojunior.sample.threads.tasks;

/**
 * @author 01456231650
 *
 */
public class MyRunnable extends AbstractMyTask implements Runnable {
	/**
	 * Construtor padrão.
	 * @param id
	 */
	public MyRunnable(int id) {
		super(id);
	}
	
	/**
	 * Construtor padrão.
	 * @param id
	 */
	public MyRunnable(int id, int delay) {
		super(id, delay);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		System.out.println("MyRunnable execution id: " + id);
		delay(); 
	}
}
