package org.training.training_main.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
	static class A{
		int value;
		
		A(int v){
			this.value = v;
		}
		
		@Override
		public int hashCode() {
			return 1;
		}
		
		@Override
		public boolean equals(Object obj) {
			A a1 = (A)obj;
			return value == a1.value;
		}
	}
	
	public static void main(String[] args) {
		Map<A, String> map = new HashMap<A, String>();
		map.put(new A(2), "A");
		map.put(new A(3), "B");
		map.put(new A(4), "C");
		for(Entry<A, String> entry: map.entrySet()) {
			System.out.println(entry.getKey().value+" "+entry.getValue());
		}		
		Map<A, String> synchronisedMap = Collections.synchronizedMap(map);
		synchronisedMap.put(null, null);
		Map<A, String> concurrentMap = new ConcurrentHashMap<A, String>(map);
		concurrentMap.put(new A(5), null);
		
	}
}
