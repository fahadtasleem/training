package learn.java8;

import java.util.Arrays;

public class ArrayParallelSort {
	public static void main(String[] args) {
		String[] strs = new String[] {"abc","a","dfdfd","df"};
		Arrays.parallelSort(strs);
		System.out.println(Arrays.toString(strs));
	}
}
