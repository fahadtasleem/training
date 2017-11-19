package org.training.training_main.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterating {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add("e");
		Iterator<String> iterator = strings.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		iterator.remove();
		System.out.println(strings);
	//	Hashtable<String, String> t = new Hashtable<String, String>();
	//	t.put("dfdsf", null);
	}
}
