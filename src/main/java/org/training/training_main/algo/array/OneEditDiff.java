package org.training.training_main.algo.array;

public class OneEditDiff {
    public static void main(String[] args) {
        System.out.println(isOneEditDiff("cat", "actaa"));
        System.out.println(longestSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    static int longestSum(int[] arr){
        int maxSum = Integer.MIN_VALUE, maxEndingHere = 0;
        for(int i=0;i< arr.length;i++){
            maxEndingHere = maxEndingHere + arr[i];
            if(maxEndingHere > maxSum){
                maxSum = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSum;
    }

    private static boolean isOneEditDiff(String s1, String s2) {
        if(Math.abs(s1.length()  - s2.length() ) > 1){
            return false;
        }
        int diff = 0;
        int l = s1.length()>s2.length()?s1.length():s2.length();
        if(s2.length()> s1.length()){
            String t = s1;
            s1 = s2;
            s2 = t;
        }
        int i = 0;
        int j = 0;
        while (i < l){
            if(s1.charAt(i) != s2.charAt(j)){
                if(s1.length() > s2.length()) {
                    i++;
                }else {
                    i++;
                    j++;
                }

                diff++;
            }else{
                i++;
                j++;
            }
            if(i >= s1.length() || j>=s2.length()){
                break;
            }
        }
        if(diff > 1){
            return false;
        }
        return true;
    }
}
