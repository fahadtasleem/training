package inherit;

public class TestInherit {
	static class E{
		public int salary = 3;
		
		public int getSalary() {
			return 4;
		}
	}
	
	static class M extends E{
		public int salary = 6;
		
		public int getSalary() {
			return 8;
		}
	}
	
	public static int getS(E e) {
		return 4;
	}
	
	public static int getS(M e) {
		return 7;
	}
	
	public static void main(String[] args) {
		E e = new M();
		System.out.println(e.salary+" "+e.getSalary());
		M m = (M)e;
		System.out.println(m.salary+" "+m.getSalary());
		System.out.println(getS(e));
		System.out.println(getS(m));
	}
}
