package org.training.training_main.algo.array.dp;

import java.util.Arrays;

public class DPEdiDistance {
/**
 * Edit distance is a way of quantifying how dissimilar two strings are, i.e., how many operations (add, delete or replace character)
 *  it would take to transform one string to the other. This is one of the most common variants of edit distance, also called Levenshtein distance,
 *   named after Soviet computer scientist, Vladimir Levenshtein. There are 3 operations which can be applied to either string, namely: 
 *   insertion, deletion and replacement. 	
 */
	
	/*
	 * How many deletion/substituion or insert are required to convert one string to another
	 * Let’s look at the DP table when s1 = “sitting” (source string) s2 = “kitten” (target string) 
	 */
	static int editDistance(String source,String target) {
		int n = source.length();
		int m = target.length();
		int[][] dp = new int[n+1][m+1];
		// source can be transformed into target prefix by inserting  
        // all of the characters in the prefix    
		for(int i=1;i<=n;i++) {
			dp[i][0] = i;
		}
		// source prefixes can be transformed into empty string by  
        // by deleting all of the characters  
		for(int i=1;i<=m;i++) {
			dp[0][i] = i;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(source.charAt(i-1) == target.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {  
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],    // substitution  
                            Math.min(dp[i][j - 1],     // insertion  
                                dp[i - 1][j]));    // deletion  
                }  
			}
		}
		for(int[] a: dp)
			System.out.println(Arrays.toString(a));
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		System.out.println(editDistance("sitting", "kitten"));
		
	}
}
