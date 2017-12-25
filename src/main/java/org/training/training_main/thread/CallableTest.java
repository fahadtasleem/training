package org.training.training_main.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableExample1 implements java.util.concurrent.Callable<Object> {
	int i;
	public CallableExample1(int i) {
		this.i = i;
	}

	public Object call() throws Exception {
		Random generator = new Random();
		Integer randomNumber = generator.nextInt(5);

		Thread.sleep(randomNumber * 1000);

		return i;
	}

}

public class CallableTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<java.util.concurrent.Callable<Object>>[] randomNumberTasks = new FutureTask[5];

		for (int i = 0; i < 5; i++) {
			Callable callable = new CallableExample1(i);

			// Create the FutureTask with Callable
			randomNumberTasks[i] = new FutureTask(callable);

			// As it implements Runnable, create Thread
			// with FutureTask
			Thread t = new Thread(randomNumberTasks[i]);
			t.start();
		}

		for (int i = 0; i < 5; i++) {
			// As it implements Future, we can call get()
			System.out.println(randomNumberTasks[i].get());

			// This method blocks till the result is obtained
			// The get method can throw checked exceptions
			// like when it is interrupted. This is the reason
			// for adding the throws clause to main
		}
	}
}
