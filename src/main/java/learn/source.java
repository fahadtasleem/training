package learn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class source {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a = new ArrayList<String>();
		Iterator<String> i = a.iterator();
		while(i.hasNext()){
			String s = i.next();
		}
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the elements separated by spaces: ");
	    String input = sc.nextLine();
	    StringTokenizer strToken = new StringTokenizer(input);
	    int count = strToken.countTokens();
	    //Reads in the numbers to the array
	    System.out.println("Count: " + count);
	    int[] arr = new int[count];

	    for(int x = 0;x < count;x++){
	        arr[x] = Integer.parseInt((String)strToken.nextElement());
	        System.out.print(arr[x]);
	    }


	}

}
