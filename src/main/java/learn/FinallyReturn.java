package learn;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinallyReturn {
	static class A implements Cloneable{
		public int a =10;
		public void test() throws AException{
			System.out.println("Test A "+this.a);
		}
		
		public Object clone()throws CloneNotSupportedException{  
			return super.clone();  
		}  
	}
	
	static class B extends A{
		@Override
		public void test() { 
			System.out.println("Test B");
		}
		
		@Override
		public int hashCode() {
			return 1;
		}
		
		@Override
		public boolean equals(Object obj) {
			return true;
		}
	}
	
	static int getValue(){
		int i=10;
		try{
			return i;
		}finally{
			i=20;
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException,AException {
		System.out.println(getValue());
		A a = new B();
		a.test();
		A b = (A)a.clone();
		a.test();
		a.a=20;
		System.out.println(a.a +" "+b.a);
		Map<A, Integer> map = new HashMap<FinallyReturn.A, Integer>();
		map.put(a, 1);
		map.put(b,2);
		System.out.println(map.size());
	}
}
