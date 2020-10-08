package org.training.training_main.algo;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] list, int start, int end) {
		if (list.length <= 1) {
			return;
		}
		if (start < end) {
			int mid = start+ (end - start) / 2;
			mergeSort(list, start, mid);
			mergeSort(list, mid + 1, end);
			int[] temp = new int[end+1];
			for (int i = start; i <= end; i++) {
				temp[i] = list[i];
			}
			int k = start;
			int i = start;
			int j = mid + 1;
			while (i <= mid && j <= end) {
				if (temp[i] <= temp[j]) {
					list[k] = temp[i];
					i++;
				} else {
					list[k] = temp[j];
					j++;
				}
				k++;
			}
			while (i <= mid) {
				list[k] = temp[i];
				k++;
				i++;
			}
		}

	}

	public static void main(String[] args) {
		int[] numbers = { 10, 5, 7, 9, 3, 1, 2, 11, 8 };
		mergeSort(numbers, 0, numbers.length - 1);
		for (int i : numbers) {
			System.out.print(i+" ");
		}
		System.out.println("");
		numbers = new int[]{ 10, 5, 7, 9, 3, 1, 2, 11, 8 };
		System.out.println(Arrays.toString(numbers));
	}

}
