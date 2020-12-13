/**
 * 
 */
package com.ss.asgn4.producerConsumer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dlance Uses LinkedBlockingQueue to ensure thread safety when
 *         producing/consuming Will produce and consume integers, automatically
 *         pausing when queue is empty or full
 */
public class ProducerConsumer {
	private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

	// put integer in queue, waiting if queue is full
	void produce() throws InterruptedException {
		queue.put(0);
	}

	// consume integer from queue, waiting if queue is empty
	void consume() throws InterruptedException {
		queue.take();
	}
	
	Integer getSize() {
		return queue.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProducerConsumer integerQueue = new ProducerConsumer();

		Thread producerThread = new Thread(() -> {
			while (true) {
				try {
					integerQueue.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread consumerThread = new Thread(() -> {
			while (true) {
				try {
					integerQueue.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumerThread.start();
		
		while (true) {
			try {
				Thread.sleep(100);
				System.out.println("Queue size: " + integerQueue.getSize());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
