package learn;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] elems,int n,int start,int end){
		int pilot = start;
		System.out.println(start+" "+end);
		if (start < end) {
			pilot = (start + end) / 2;
			mergeSort(elems, n, start, pilot);
			mergeSort(elems, n, pilot + 1, end);

			int j = pilot + 1;
			int k = start;
			int temps[] = new int[end + 1];
			for (int i = start; i <= end; i++) {
				temps[i] = elems[i];
			}
			int i = start;
			System.out.println(Arrays.toString(temps));
			System.out.println("Pilot " + pilot);
			for (; i <= pilot && j <= end;) {
				System.out.println("Inside for ");
				System.out.println(Arrays.toString(temps) + " temps");
				if (i <= pilot && j <= end) {
					if (temps[i] >= temps[j]) {
						elems[k] = temps[j];
						j++;
					} else {
						elems[k] = temps[i];
						i++;
					}
				}
				k++;
			}
			while (i <= pilot) {
				elems[k] = temps[i];
				k++;
				i++;
			}
			System.out.println("After " + Arrays.toString(elems));
		}
	}
	
	public static void main(String[] ar){
		int[] elems = new int[]{27,5,2,6,-5,12,1};
		System.out.println(Arrays.toString(elems));
		mergeSort(elems, elems.length, 0, elems.length-1);
		System.out.println(Arrays.toString(elems));
	}
}
