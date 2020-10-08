package org.training.training_main.algo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.mahout.math.Arrays;

//https://www.hackerrank.com/challenges/queries-with-fixed-length/problem
public class SlidingWindow {
	static int getMin(int[] numbers,int d){
        Queue<Integer> window = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < d; i++) {
            int current = numbers[i];
            window.add(current);
            if (current > max)
                max = current;
        }
        
        if (max < min)
            min = max;
        int N = numbers.length;
        for (int i = 1; i <= N - d; i++) {
            int numToAdd = numbers[i + d - 1];
            window.add(numToAdd);
            if (numToAdd >= max)
                max = numToAdd;
            
            if (window.remove() == max) {
                max = Collections.max(window);
            }
            
            if (max < min)
                min = max;
        }

        return min;
    }
    // Complete the solve function below.
    static int[] solve(int[] arr, int[] queries) {
        int[] maxs = new int[queries.length];
        int i =0;
        for(int q:  queries){
            maxs[i++] = (getMin(arr,q));
        }
        return maxs;
    }

    public static void main(String[] args) {
		int[] n = new int[]{11,44,33,22,55};
		int[] queries = new int[] {2,4};
		int[] res = solve(n, queries);
		System.out.println(Arrays.toString(res));
	}
}
