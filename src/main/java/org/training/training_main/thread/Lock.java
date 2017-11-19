package org.training.training_main.thread;

public class Lock {
	private static Object obj = new Object();
	private static boolean isLocked = false;
	
	public void lock() throws InterruptedException {
		synchronized (obj) {
			if(isLocked) {
				System.out.println("Waiting "+Thread.currentThread().getId());
				obj.wait();
			}
			isLocked = true;
			System.out.println("Locked "+Thread.currentThread().getId());
		}
	}
	
	public void unlock() {
		synchronized (obj) {
			if(isLocked) {
				isLocked = false;
				obj.notify();
				System.out.println("Unlock");
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable r = ()->{
			Lock lock = new Lock();
			try {
				System.out.println("Locking.....");
				lock.lock();
			} catch (InterruptedException e) {
				System.out.println("Exception while locking.....");
			}
			System.out.println("Locked expression "+Thread.currentThread().getId());
			lock.unlock();
		};
		int num = 5;
		Thread[] t = new Thread[num];
		for(int i=0;i<num;i++) {
			t[i] = new Thread(r);
			t[i].start();
		}
		
	}
}
