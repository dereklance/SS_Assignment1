/**
 * 
 */
package com.ss.asgn4.deadlock;

/**
 * @author dlance
 * Create a deadlock between 2 threads
 */
public class Deadlock {

	public static void main(String[] args) {
		Integer resource1 = 0;
		Integer resource2 = 0;
		
		var thread1 = new Thread(() ->{
			synchronized(resource1) {
				try {
					Thread.sleep(100);
					
				} catch (InterruptedException e) {
					synchronized (resource2) {
						System.out.println("Thread 1 got resource 2!");
					}
				}
				
			}
		});
		
		var thread2 = new Thread(() ->{
			synchronized(resource2) {
				try {
					Thread.sleep(100);
					
				} catch (InterruptedException e) {
					synchronized (resource1) {
						System.out.println("Thread 2 got resource 1!");
					}
				}
				
			}
		});
		
		
		thread1.start();
		thread2.start();
		
		System.out.println("Done");
	}

}
