package learn.string;

import java.util.HashSet;
import java.util.Set;

public class StringHelper {
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        System.out.println(initial+"- "+rem);
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    //https://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/
    static int findNumberOfStrings(int n, int b, int c){
        if(b < 0){
            return 0;
        }
        if(c < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if (b == 0 && c == 0) return 1;
        int res = findNumberOfStrings(n-1,b,c);
        res += findNumberOfStrings(n-1,b-1,c);
        res += findNumberOfStrings(n-1,b,c-1);
        return res;
    }

    //Check if the given string is K-periodic
    static boolean checkIsKPeriodic(String s,int k){
        if(s.length()%k != 0){
            return false;
        }
        int n = s.length();
        int l = n/k;
        for(int i=0;i<k;i++){
            char c = s.charAt(i);
            for(int j=1;j<l;j++){
                if(c != s.charAt(k*j+i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "AAC";
        String s1 = "ABC";
        String s2 = "ABCD";
       // System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
       // System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
        System.out.println(findNumberOfStrings(3,1,2));
        System.out.println(checkIsKPeriodic("abababab",2));
    }
}