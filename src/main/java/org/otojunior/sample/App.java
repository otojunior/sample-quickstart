package org.otojunior.sample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
	
	public static final BlockingQueue<String> q = new ArrayBlockingQueue<String>(5);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LOG.info("sample-quickstart Application.");

		new Producer().start();
		new Consumer().start();
		
		LOG.info("End");
	}

	/**
	 * 
	 * @author 01456231650
	 *
	 */
	public static class Producer extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 20; i++) {
					App.q.put("element " + i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class Consumer extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 20; i++) {
					String str = App.q.take();
					System.out.println(str);
					Thread.sleep(3000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
