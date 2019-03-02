package org.training.training_main.algo;

public class LCS {
	static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int L[][] = new int[m + 1][n + 1];
		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	public static void main(String[] args) {
		System.out.println(lcs("HARRY", "SALLY"));
	}
}
