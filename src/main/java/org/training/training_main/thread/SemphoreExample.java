package org.training.training_main.thread;

import java.util.concurrent.Semaphore;

public class SemphoreExample {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(5);
		Runnable r = ()->{
			System.out.println("Locking....."+Thread.currentThread().getId());
			try {
				sem.acquire();
			} catch (InterruptedException e) {
				System.out.println("Inttercupte "+Thread.currentThread().getId());
			}
			System.out.println("Locked expression "+Thread.currentThread().getId());
			sem.release();
			System.out.println("Release "+Thread.currentThread().getId());
		};
		int num = 5;
		Thread[] t = new Thread[num];
		for(int i=0;i<num;i++) {
			t[i] = new Thread(r);
			t[i].start();
		}
	}
}
