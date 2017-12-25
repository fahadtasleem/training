package org.training.training_main.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQ {
	
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> q = new ArrayBlockingQueue<String>(1);
		q.put("sdfsd");
	}
}
