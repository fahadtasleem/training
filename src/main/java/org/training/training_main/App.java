package org.training.training_main;

import java.util.Arrays;

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
        System.out.print(hasString("sadcddfdfb", "abc"));
        
    }
    
    static boolean hasString(String in, String reg){
        char[] inChars = in.toCharArray();
        Arrays.sort(inChars);
        in = new String(inChars);
        System.out.println(in);
        boolean hasSubString = true;
        int lastIndex = 0;
        for(int j=0;j<reg.length();j++){
            char c = reg.charAt(j);
            boolean found = false;
            for(int i =lastIndex;i<inChars.length;i++){
                 System.out.println(inChars[i]+"  "+c);
                if(inChars[i] == c){
                	System.out.println("Found "+c+" "+i);
                    lastIndex = i;
                    found=true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return hasSubString;
    }
}
