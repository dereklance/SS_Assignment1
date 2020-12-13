/**
 * 
 */
package com.ss.asgn4.singleton;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

/**
 * @author dlance
 *
 */
class SingletonDoubleCheckTest {
	private SingletonDoubleCheck single = SingletonDoubleCheck.getInstance();
	
	// ensure getInstance() returns the same instance
	@Test
	void getInstanceTest() {
		assertSame(single, SingletonDoubleCheck.getInstance());
	}
	
	// spawn many threads that call getInstance
	// reset instance to null periodically to test the thread safety of first initialization
	@Test
	void threadTest() {
		var singletons = new ArrayList<SingletonDoubleCheck>();
		
		Runnable task = () -> {
			var singleton = SingletonDoubleCheck.getInstance();
			singletons.add(singleton);
		};
		
		// number of times to run NUM_THREADS threads
		final int THREAD_GROUPS = 1000;
		
		// threads to run before resetting instance to null
		final int NUM_THREADS = 10;
		
		for (int groupNum = 0; groupNum < THREAD_GROUPS; groupNum++) {
			singletons.clear();
			var threads = new Runnable[NUM_THREADS];
			
			for (int i = 0; i < NUM_THREADS; i++) {
				threads[i] = task;
			}
			
			runAndAwaitThreads(threads);
			
			for (int i = 0; i < singletons.size(); i++) {
				assertSame(SingletonDoubleCheck.getInstance(), singletons.get(i));
			}
			
			resetInstance();
		}
	}
	
	// use reflection to reset the instance to null
	private void resetInstance() {
		try {
			Field instance = SingletonDoubleCheck.class.getDeclaredField("instance");
			instance.setAccessible(true);
			instance.set(null, null);
		}
		catch (Exception e) {
			fail("Variable does not exist.");
		}
	}
	
	// runs the provided threads in parallel, and waits until all threads have completed before continuing
	private void runAndAwaitThreads(Runnable ...threads) {
		Stream.<Runnable> of(threads)
			.parallel()
			.forEach(Runnable::run);
	}

}
