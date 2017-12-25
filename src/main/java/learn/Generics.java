package learn;

public class Generics {
	public static  class A<P extends Number>{
		<B> String getType(B c) {
			return "dfsa";
		}
	}
	
	public static void main(String[] args) {
		A<Number> a = new A<Number>();
		A<Integer> b = new A<Integer>();
	}
}
