package org.training.training_main.thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.collect.Lists;

public class MyExecutor implements Runnable{
	private Thread t;
	private BlockingQueue<Runnable> lists;
	private Object o;
	Lock lock;
	
	private MyExecutor() {
		t = new Thread(this);
		lists = new LinkedBlockingQueue<Runnable>();
		lock = new ReentrantLock();
		o = new Object();
		t.start();
	}
	
	public void submit(Runnable r) {
		lists.offer(r);
		if(!t.isAlive()) {
			lock.lock();
			if(!t.isAlive()) {
				t.start();
			}
			lock.unlock();
		}
		if(lists.size() == 1) {
			synchronized (o) {
				o.notify();
			}
		}
	}
	
	@Override
	public void run() {
		while(true) {
			if(lists.isEmpty()) {
				synchronized (o) {
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			Runnable r = lists.poll();
			r.run();
		}	
	}
	
	static MyExecutor newSingleThread() {
		return new MyExecutor();
	}
	
	
	public static void main(String[] args) {
		MyExecutor e = newSingleThread();
		ExecutorService es = Executors.newSingleThreadExecutor();
		List<Runnable> l = Lists.newArrayList();
		for(int i=0;i<5;i++) {
			final int k = i;
			l.add(new Runnable(){
				public void run() {
					for(int j=0;j<3;j++) {
						System.out.println("Runnalle "+k+" - "+j);
					}
				}
			});
		}
		for(Runnable r : l) {
			e.submit(r);
		}
		for(Runnable r : l) {
//			es.submit(r);
			es.execute(r);
		}
	}
}
