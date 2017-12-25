package learn;

public class Inheritance {
	static class A{
		private String a;
		final protected String b;
		
		public A(String a, String b) {
			this.a = a;
			this.b= b;
		}
		
		final String getB() {
			return b;
		}
	}
	
	static class B extends A{
		String a;
		String b;
		
		public B(String a, String b) {
			super(a,b);
			this.a = a;
			this.b= b;
		}

		public String getSuperB() {
			return super.b;
		}
	}
	
	public static void main(String[] args) {
		B a = new B("1", "2");
		a.b = "3";
		System.out.println(" "+ a.b+" "+a.getB()+" "+a.getSuperB());
	}
}
