/**
 * 
 */
package org.otojunior.sample.threads.runner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 01456231650
 *
 */
public class FixedThreadExecutorRunner extends AbstractExecutorRunner {
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FixedThreadExecutorRunner executor = new FixedThreadExecutorRunner();
		
		ExecutorService instance1 = Executors.newFixedThreadPool(5);
		ExecutorService instance2 = Executors.newFixedThreadPool(5);
		ExecutorService instance3 = Executors.newFixedThreadPool(5);
		ExecutorService instance4 = Executors.newFixedThreadPool(5);
		
		executor.execute(instance1);
		executor.submitRunnable(instance2);
		executor.submitCallable(instance3);
		executor.invokeAll(instance4);
	}
}
