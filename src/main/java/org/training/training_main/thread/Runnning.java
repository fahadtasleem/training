package org.training.training_main.thread;

public class Runnning implements Runnable{
	 static volatile int d = 10;
	
	@Override
	public void run() {
		System.out.println("Runnint "+(++d)+" "+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		Runnning r = new Runnning();
		Runnning r2 = new Runnning();
		Runnning r3 = new Runnning();
		Thread t = new Thread(r,"r1");
		Thread t2 = new Thread(r2,"r2");
		Thread t3 = new Thread(r3,"r3");
		
		t.start();
		t2.start();
		t3.start();
	}

}
