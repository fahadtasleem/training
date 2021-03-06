package org.training.training_main.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestSequenceOfPair {
	public static void main(String[] args) {
		Integer[][] arr = {
				{3,9},
				{1,8},
				{6,7},
				{20,25},
				{30,40},
				{31,40}
		};
		
		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[0] < o2[0]) {
					return -1;
				}else if(o1[0] > o2[0]) {
					return 1;
				}
				return 0;
			}
			
		});
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		List<Integer[]> list = new ArrayList<Integer[]>();
		int length = 0;
		getLength(arr, 0);
	}

	private static void getLength(Integer[][] arr, int in) {
		List<Integer>[] L = new List[arr.length];
		for(int i=0;i<arr.length;i++) {
			L[i] = new ArrayList<Integer>();
		}
		L[0].add(0);
	    for(int i=1;i<arr.length;i++) {
	    		for(int j=0;j<i;j++) {
	    			if(arr[j][1] < arr[i][0] && (L[i].size() < L[j].size()+1)) {
	    				L[i] = new ArrayList<>(L[j]);
	    				
	    			}
	    		}
	    		L[i].add(i);
	    }
	    int l =0;
	    for(List<Integer> f: L) {
	    		System.out.println(f.toString());
	    		if(f.size()>l) {
	    			l = f.size();
	    		}
	    }
	    System.out.println(l);
	}
}
