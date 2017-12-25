package org.training.training_main.thread;

public class ThreadSleepInterrupt {
	static class R implements Runnable{

		@Override
		public void run() {
			try {
				System.out.println("Sleeping");
				synchronized (this) {
					this.notify();					
					System.out.println("Notify");
				}
				Thread.sleep(4000);
				System.out.println("Slept");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread r = new Thread(new R());
		r.start();
		//r.interrupt();
		synchronized (r) {
			System.out.println("Wait starts");
			r.wait();
			System.out.println("Wait ends");
			
			r.notify();
		}
	}
}
