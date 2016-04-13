/**
 * 
 */
package org.otojunior.sample.threads.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.otojunior.sample.threads.tasks.MyCallable;
import org.otojunior.sample.threads.tasks.MyRunnable;
import org.otojunior.sample.util.Sequence;

/**
 * @author 01456231650
 *
 */
public abstract class AbstractExecutorRunner {
	protected ExecutorService service;
	
	/**
	 * 
	 * @throws InterruptedException
	 */
	protected void execute(ExecutorService service) throws InterruptedException {
		this.service = service;
		for (int i = 0; i < 10; i++) {
			MyRunnable myTask = new MyRunnable(Sequence.nextInt());
			this.service.execute(myTask);
		}
		
		this.service.shutdown();
		this.service.awaitTermination(10, TimeUnit.SECONDS);
		
		System.out.println("------------------------------");
	}
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	protected void submitRunnable(ExecutorService service) throws InterruptedException, ExecutionException {
		this.service = service;
		List<Future<?>> lst = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			MyRunnable myTask = new MyRunnable(Sequence.nextInt());
			Future<?> future = this.service.submit(myTask);
			lst.add(future);
		}
		
		for (Future<?> future : lst) {
			System.out.println("Future: " + future.get());
		}
	
		this.service.shutdown();
		this.service.awaitTermination(10, TimeUnit.SECONDS);
		
		System.out.println("-------------------------------");
	}
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	protected void submitCallable(ExecutorService service) throws InterruptedException, ExecutionException {
		this.service = service;
		List<Future<?>> lst = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			MyCallable myTask = new MyCallable(Sequence.nextInt());
			Future<?> future = this.service.submit(myTask);
			lst.add(future);
		}
		
		for (Future<?> future : lst) {
			System.out.println("Future: " + future.get());
		}
	
		this.service.shutdown();
		this.service.awaitTermination(10, TimeUnit.SECONDS);
		
		System.out.println("-------------------------------");
	}
	
	/**
	 * 
	 * @param service
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	protected void invokeAll(ExecutorService service) throws InterruptedException, ExecutionException {
		this.service = service;

		List<Callable<Integer>> lstCallables = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			MyCallable myTask = new MyCallable(Sequence.nextInt());
			lstCallables.add(myTask);
		}
		
		List<Future<Integer>> futures = this.service.invokeAll(lstCallables);
		
		for (Future<?> future : futures) {
			System.out.println("Future: " + future.get());
		}
		
		this.service.shutdown();
		this.service.awaitTermination(10, TimeUnit.SECONDS);
	}
}
