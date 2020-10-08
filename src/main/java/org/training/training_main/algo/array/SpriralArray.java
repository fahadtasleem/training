package org.training.training_main.algo.array;

import java.util.Arrays;

public class SpriralArray {
    public static void main(String[] args) {
        int[][] out= spiral(3);
        for(int i=0;i<out.length;i++){
            System.out.println(Arrays.toString(out[i]));
        }
    }

    private static int[][] spiral(int n) {
        int[][] a =  new int[n][n];
        int i, k = 0, l = 0, m =n ;
        int value = 1;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                a[k][i] = value++;
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i) {
                a[i][n - 1] = value++;
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
//                    System.out.print(a[m - 1][i] + " ");
                    a[m - 1][i] = value++;
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
//                    System.out.print(a[i][l] + " ");
                    a[i][l] = value++;
                }
                l++;
            }
        }
        return a;
    }
}
