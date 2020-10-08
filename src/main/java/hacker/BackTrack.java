package hacker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrack {
    public static void main(String[] args) {
//        int[][] grid = solveNQueen(4);
//        print(grid);
//        allPrime(2,28,7);
        allPrime(4,54,3);
    }

    private static void print(int[][] grid) {
        for(int[] n : grid){
            System.out.println(Arrays.toString(n));
        }
    }

    static int[][] solveNQueen(int n){
        int[][] grid = new int[n][n];
        int[][] visited = new int[n][n];

        boolean solved = solveNQueenUtils(grid,n,0);
        System.out.println(solved+"----");
        return grid;
    }

    private static boolean solveNQueenUtils(int[][] grid, int n, int col) {
        if(col>= n){
            System.out.println("----");
            print(grid);
            return true;
        }
        boolean res = false;
        for(int i=0;i<n;i++){
            if(isSafe(grid,i,col)){
                grid[i][col] = 1;
                res = solveNQueenUtils(grid,n,col+1) || res;
//                    return true;
                grid[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (grid[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (grid[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < grid.length; i++, j--)
            if (grid[i][j] == 1)
                return false;

        return true;
    }

    static List<int[]> allPrime(int N,int S, int P){
        List<Integer> primes = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for(int i=P+1;i<S;i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        computeAllPrime(result,primes,S,N,P,0,new ArrayList<Integer>());
        display(result);
        return result;
    }

    private static void display(List<int[]> result) {
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
    }

    private static void computeAllPrime(List<int[]> result, List<Integer> primes, int s, int n, int p, int i, List<Integer> till) {
        if(till.size() == n){
            int sum = 0;
            for(int k=0;k<n;k++){
                sum+=till.get(k);
            }
            if(sum == s){
                int[] r = new int[n];
                for(int k=0;k<n;k++){
                    r[k]=till.get(k);
                }
                result.add(r);
            }
            return;
        }
        for(int j =i;j<primes.size();j++){
            int index = primes.size();
            till.add(primes.get(j));
            computeAllPrime(result,primes,s,n,p,j+1,till);
            till.remove(till.size()-1);
        }
//        if(till.size()>0){
//            till.remove(till.size()-1);
//        }
    }

    private static boolean isPrime(int x) {
        // square root of x
        int sqroot = (int)Math.sqrt(x);

        // since 1 is not
        // prime number
        if (x == 1)
            return false;

        // if any factor is
        // found return false
        for (int i = 2;
             i <= sqroot; i++)
            if (x % i == 0)
                return false;

        // no factor found
        return true;
    }
}
