package org.training.training_main.algo;

public class BinarySearch {
	public static int search(int[] input,int element,int start,int end){
		if(start <= end){
			int mid = (end-start)/2+start;
			if(input[mid]<element){
				return search(input,element,mid+1,end);
			}else if(input[mid]>element){
				return search(input,element,start,mid-1);
			}else if(input[mid] == element){
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[]{2,4,6,7,8,12,92,98};
		//System.out.println(search(a, 4, 0, a.length-1));
		//System.out.println(binarySearch(a,0,a.length-1,4));
		for(int i=0;i<a.length ;i++){
			int el = a[i];
			int diff = 100 -el;
			int find = search(a, diff, 0, a.length-1);
			if(find != -1){
				System.out.println("Comp "+el+" "+diff);
			}
		}
	}
}
