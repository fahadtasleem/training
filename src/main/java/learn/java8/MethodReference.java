package learn.java8;

import java.util.Arrays;

public class MethodReference {
	public static int compareByLength(String in, String out){
        return in.length() - out.length();
    } 
	
	public int reverse(String in, String out){
        return -in.length() + out.length();
    } 
	
	
	public static void main(String[] args) {		
		String[] strs = new String[] {"abc","a","dfdfd","df"};
		Arrays.sort(strs, MethodReference::compareByLength);
		System.out.println(Arrays.toString(strs));
		MethodReference m = new MethodReference();
		Arrays.sort(strs,m::reverse);
		System.out.println(Arrays.toString(strs));
	}
}
