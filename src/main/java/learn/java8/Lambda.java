package learn.java8;

public class Lambda {
	public static void run() {
		System.out.println("Hello..");
	}
	
	public static void main(String[] args) {
		int d = 10;
		Thread t = new Thread(Lambda::run);
		t.start();
		// Applies only to functional interfaces
		MathOperation plus = (a,b)->{int c=a+b+d;
		return c;};
		
		System.out.println(plus.operation(1, 3));
	}
}

// Functional interface
interface MathOperation {
    int operation(int a, int b);
}