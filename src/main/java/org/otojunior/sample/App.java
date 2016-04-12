package org.otojunior.sample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LOG.info("sample-quickstart Application.");

		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(1, 240);
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		forkJoinPool.invoke(myRecursiveAction);
		forkJoinPool.shutdown();
		forkJoinPool.awaitTermination(3, TimeUnit.SECONDS);
	}
}
