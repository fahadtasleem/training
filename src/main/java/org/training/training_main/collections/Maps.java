package org.training.training_main.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		for(Entry<String, String> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}		
		Map<String, String> synchronisedMap = Collections.synchronizedMap(map);
		synchronisedMap.put(null, null);
		Map<String, String> concurrentMap = new ConcurrentHashMap<String, String>(map);
		concurrentMap.put("d", null);
		
	}
}
