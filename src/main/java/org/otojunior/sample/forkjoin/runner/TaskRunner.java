/**
 * 
 */
package org.otojunior.sample.forkjoin.runner;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.otojunior.sample.forkjoin.tasks.MyRecursiveTask;
import org.otojunior.sample.util.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class TaskRunner {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(TaskRunner.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyRecursiveTask myTask = new MyRecursiveTask(Sequence.nextInt(), 50);
			
			ForkJoinPool forkJoinPool = new ForkJoinPool(4);
			Long merged = forkJoinPool.invoke(myTask);
			forkJoinPool.shutdown();
			forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
			
			LOG.info("Merged Result: " + merged.longValue());
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
