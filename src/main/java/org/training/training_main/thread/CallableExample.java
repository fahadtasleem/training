package org.training.training_main.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableExample<V> implements Callable<V>{
	V c;
	CallableExample(V c){
		this.c = c;
	}
	
	
	@Override
	public V call() throws Exception {
		Thread.sleep(1000);
		System.out.println("inside thread "+this.c);
		return this.c;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String>[] callables = new Callable[5];
		for(int i=0;i<callables.length;i++) {
			callables[i] = new CallableExample<String>(i+"");
		}
		List <FutureTask<String>> list = new ArrayList<FutureTask<String>>();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0;i<callables.length;i++) {
			list.add(new FutureTask<>(callables[i]));
			executor.execute(list.get(i));
		}
		for(Future<String> f : list) {
			System.out.println(f.isDone());
			System.out.println(f.get());
			System.out.println("------- "+f.isDone());
		}
		executor.shutdown();
		
		new Thread(new FutureTask<>(callables[0])).start();
	}

	
}
