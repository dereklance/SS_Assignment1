/**
 * 
 */
package com.ss.asgn4.singleton;

/**
 * @author dlance
 * Singleton class with double checked locking
 * Assignment 4
 */
public class SingletonDoubleCheck {
	// must be declared volatile to ensure thread safety and avoid CPU cache issues
	private static volatile SingletonDoubleCheck instance;
	
	// prevent others from instantiating a new object
	private SingletonDoubleCheck() {}
	
	public static SingletonDoubleCheck getInstance() {
		
		// check to see if we have an instance before locking the thread
		if (instance == null) {
			synchronized (SingletonDoubleCheck.class) {
				
				// check to see if we have an instance again before instantiating
				if (instance == null) {
					instance = new SingletonDoubleCheck();
				}
			}
		}
		return instance;
	}
}
