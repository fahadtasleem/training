package learn.java8;

import java.util.Objects;

public class Validation {
	
	static void validateNull(String a) {
		String b = Objects.requireNonNull(a);
		System.out.println(b);
		
	}
	
	public static void main(String[] args) {
		validateNull("sdfS----\n");
		validateNull(null);
	}
}
