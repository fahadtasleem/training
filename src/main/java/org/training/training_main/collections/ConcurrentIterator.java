package org.training.training_main.collections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentIterator {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		map.put("d", "D");
		map.put("e", "E");
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key);
			if(key == "a") {
				iterator.remove();
			}
		}
		System.out.println("---------------");
		map.keySet().stream().forEach((key)->{
			System.out.println(key);
		});
		System.out.println("---------------");
		for(String key: map.keySet()) {
			if(key == "b") {
				map.remove(key);
			}
		}
		map.keySet().stream().forEach((key)->{
			System.out.println(key);
		});
	}
}
