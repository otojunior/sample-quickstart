/**
 * 
 */
package org.otojunior.sample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.otojunior.sample.tasks.MyRecursiveAction;
import org.otojunior.sample.util.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class ActionRunner {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ActionRunner.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyRecursiveAction myAction = new MyRecursiveAction(Sequence.nextInt(), 50);
			
			ForkJoinPool forkJoinPool = new ForkJoinPool(4);
			forkJoinPool.invoke(myAction);
			forkJoinPool.shutdown();
			forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
