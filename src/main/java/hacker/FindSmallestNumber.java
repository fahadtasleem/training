package hacker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindSmallestNumber {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
       // String in_ = Integer.parseInt(br.readLine().trim());
//         int N = sc.nextInt();
//         int X = sc.nextInt();
//         long K = sc.nextLong();
//         String S = sc.next();
         String out_ = Find_It(5, 10, "1234567891", 10);
         System.out.println(out_);
 
         wr.close();
         br.close();
    }
    static List<String> numbers=new ArrayList<>();
    static String Find_It(int X, long K, String S, int N){
       int totalSets=N/X;
        if(N%X>0)
            totalSets+=1;
        String[] subD=new String[totalSets];
        int index=0;
 
        for(int i=0;i<totalSets;i++){
            subD[i]=S.substring(index,((index+X)>N-1)?N:index+X);
            index+=X;
            if(index>=S.length()){
                index=index-S.length()-1;
            }
        }
        addNumberToList(subD,totalSets,0,"", K);
        Collections.sort(numbers);
        System.out.println(numbers);
        int counter=0;
        return numbers.get(numbers.size()-1);
//        return null;
    }
    private static void addNumberToList(String[] subD, int current, int number,String eachNum, long k) {
       if(current==number)
        {
            //Integer x=Integer.parseInt(eachNum);
            if(!numbers.contains(eachNum)) {
                numbers.add(eachNum);
            }
            return;
        }
        for(int x=0;x<subD[number].length();x++){
            eachNum+=subD[number].charAt(x);
            addNumberToList(subD,current,number+1,eachNum,k);
            if(numbers.size() == k) {
            	return;
            }
            eachNum=eachNum.substring(0,number);
        }
 
    }
}
