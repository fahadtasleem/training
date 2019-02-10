package org.training.training_main.algo;

public class FindNumber {
	static boolean isGreater(int num) {
		return 8000>num;
	}
	
	public static void main(String[] args) {
		int min = 0;
		int max = 1;
		long in = System.currentTimeMillis();
		System.out.println(in);
		while(true) {
			if(isGreater(max)) {
				min = max;
				max = 2*max;
			}else {
				break;
			}
		}
		//min = max/2;
		//System.out.println(min);
		int mid = (max+min)/2;
		while(min<max) {
			if(isGreater(mid)) {
				min = mid+1;
			}else {
				max = mid;
			}	
			mid = (max+min)/2;
		}
		System.out.println(mid);
		long ou = System.currentTimeMillis();
		System.out.println(ou+" "+(ou-in));
		System.out.println(Math.log(8000));
	}
}
