package org.training.training_main.algo;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] elems,int start,int end){
		if(start <end){
			int pi = partition(elems,start,end);
			quickSort(elems, start, pi-1);
			quickSort(elems, pi+1, end);
		}
	}
	
	private static int partition(int[] elems, int start, int end) {
		int pivot = elems[end]; 
        int i = (start-1); // index of smaller element
        System.out.println("S : E: "+start+' '+end);
        for (int j=start; j<end; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (elems[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = elems[i];
                elems[i] = elems[j];
                elems[j] = temp;
                System.out.println("--->"+ Arrays.toString(elems)); 
            }
        }
        System.out.println("->"+ Arrays.toString(elems)); 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = elems[i+1];
        elems[i+1] = elems[end];
        elems[end] = temp;
        System.out.println("->="+ Arrays.toString(elems)+" "+i); 
        return i+1;
	}


	public static void main(String[] ar){
//		int[] elems = new int[]{27,5,1,6,-5,12,2};
//		System.out.println(Arrays.toString(elems));
//		quickSort(elems, 0, elems.length-1);
//		System.out.println(Arrays.toString(elems));

		int[] elems1 = new int[]{27,5,1,6,-5,12,2};
		quickSort1(elems1);
        System.out.println("new ----- ");
        System.out.println(Arrays.toString(elems1));
	}

    ///// USE THIS
    public static void quickSort1(int[] arr){
	    quickSort1(arr,0,arr.length-1);
    }

    private static void quickSort1(int[] arr, int left, int right) {
	    if(left < right){
	        int pivot = arr[right];
	        int index = partition1(arr, left, right,pivot);
	        System.out.println(Arrays.toString(arr));
	        quickSort1(arr, left, index-1);
            quickSort1(arr, index, right);
        }
    }

    private static int partition1(int[] arr, int left, int right, int pivot) {
	    while(left < right){
	        while(arr[left] < pivot){
	            left++;
            }
	        while (arr[right] > pivot){
	            right--;
            }
	        if(left < right){
	            int temp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = temp;
            }
        }
	    return left;
    }
}
