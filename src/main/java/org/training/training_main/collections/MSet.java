package org.training.training_main.collections;

import java.util.HashSet;
import java.util.Set;

public class MSet {
		public static void main(String[] args) {
			Set<String> s = new HashSet<>();
			s.add("a");
			for(String a : s) {
				System.out.println(a);
			}
		}
}
