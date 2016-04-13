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
public class SingleThreadExecutorRunner extends AbstractExecutorRunner {
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SingleThreadExecutorRunner executor = new SingleThreadExecutorRunner();
		
		ExecutorService instance1 = Executors.newSingleThreadExecutor();
		ExecutorService instance2 = Executors.newSingleThreadExecutor();
		ExecutorService instance3 = Executors.newSingleThreadExecutor();
		ExecutorService instance4 = Executors.newSingleThreadExecutor();
		
		executor.execute(instance1);
		executor.submitRunnable(instance2);
		executor.submitCallable(instance3);
		executor.invokeAll(instance4);
	}
}
