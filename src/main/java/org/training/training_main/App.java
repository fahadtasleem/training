package org.training.training_main;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.math.BigInteger;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{

	static class Employee{
		String name;
		String age;
		BigInteger number;
        public Employee(){}

		public Employee(String name,String age){
			this.name = name;
			this.age = age;
		}

        public void setNumber(BigInteger number) {
            this.number = number;
        }
    }
    public static void main( String[] args ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee e = objectMapper.readValue("{\"number\": 234.34}", Employee.class);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(Instant.now().toEpochMilli()+ " "+zonedDateTime);
        System.out.print(hasString("sadcddfdfb", "abc"));
        System.out.println(new Random(100).nextInt());
        System.out.println(new Random(100).nextInt());
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
