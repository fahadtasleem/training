package org.training.training_main.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(4+1);
		long start = System.nanoTime();
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println("Start "+ System.nanoTime());
		for(int i=0;i<100;i++) {
			executor.execute(()->{
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//				}
				System.out.print(". "+Thread.currentThread().getId());
				//System.out.println("Thread id "+Thread.currentThread().getId());
			});
		}
		((ExecutorService) executor).shutdown();
        // Wait until all threads are finish
        executor.awaitTermination(2, TimeUnit.MINUTES);
        long end = System.nanoTime();
        System.out.println("Finished all threads "+System.nanoTime());
        System.out.println(start+" - "+end+" = "+(end-start));

        //867548787  882595420 2702716368
        //
        // Size 4
        //1287523564 1271296349
        //4146350598
        //57765904
        //12
        //71062201
	}
}
