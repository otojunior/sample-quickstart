/**
 * 
 */
package org.otojunior.sample.threads.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public abstract class AbstractMyTask {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractMyTask.class);
	
	protected int id;
	protected int delay = 1000;
	
	/**
	 * Construtor padrão.
	 * @param id id da tarefa.
	 */
	protected AbstractMyTask(int id) {
		this.id = id;
	}
	
	/**
	 * Construtor padrão.
	 * @param id id da tarefa.
	 */
	protected AbstractMyTask(int id, int delay) {
		this.id = id;
		this.delay = delay;
	}
	
	/**
	 * Delay de um tempo aleatório para simular um processamento de 
	 * alguma coisa.
	 */
	protected void delay() {
		try {
			long random = (long)(Math.random() * this.delay);
			Thread.sleep(random);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
