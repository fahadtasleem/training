package org.training.training_main;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
	static class Employee{
		String name;
		String age;
		Employee(String name,String age){
			this.name = name;
			this.age = age;
		}
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int h;
        System.out.println((h = 134345342));
        int i;
        System.out.println(i = 23);
        System.out.println(((h = 12) ^ (h >>> 16)));
        Map<Employee, String> m = new HashMap<>();
        Employee e1 = new Employee("a", "12");
        Employee e2= new Employee("b", "25");
        m.put(e1, "f");
        m.put(e2, "S");
        System.out.println(m.get(e1)+" "+m.get(e2));
        
    }
}
