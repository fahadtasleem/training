package org.training.training_main.algo;

import java.util.Arrays;

public class InsertionAndBubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,16,1,7,8,5,0,16};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{4,2,16,1,7,8,5,0,16};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{4,2,16,1,7,8,5,0,16};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for(int i =0;i<arr.length-1 ;i++){
            boolean swapped = false;
            for(int j=0;j<arr.length - i - 1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int ele = arr[i];
            int j = i-1;
            while(j>=0){
                if(arr[j] > ele){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
                j--;
            }
            arr[j+1] = ele;
        }
    }

    private static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++) {
            int min = arr[i];
            int jm = i;
            for (int j = i + 1; j < arr.length;j++) {
                if (arr[j] < min) {
//                    min = arr[j];
                    jm=j;
                }
            }
            if(i != jm){
                int temp = min;
                arr[i] = arr[jm];
                arr[jm] = temp;
            }
        }
    }
    

}
