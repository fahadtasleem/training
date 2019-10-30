package org.training.training_main.thread;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

public class FutureExecutionerService {
	
	public static abstract class Task implements Runnable{

		@Override
		public void run() {
			this.compute();
		}
		
		abstract void compute();
		
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<?>> tasks = Lists.newArrayList();
		for(int i=0;i<100;i++) {
			tasks.add(executorService.submit(new Task() {
				
				@Override
				void compute() {
					System.out.println(Thread.currentThread()+" b sleep" );
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread()+" A sleep" );
				}
			}));
		}
		System.out.println("Before end..-------");
		for(Future<?> f : tasks) {
			try {
				f.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("END=---------");
		executorService.shutdown();
	}	
}
