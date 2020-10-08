package org.training.training_main.algo;

import java.util.Arrays;

public class QueenProblem {
    private static int total = 0;
    public static void main(String[] args) {
        int[][] grid = new int[8][8];
        queens(grid, 0);
    }

    private static boolean isSafe(int[][] grid,int row, int column){
        // check up
        for(int i=row-1;i>=0;i--){
            if(grid[i][column] == 1){
                return false;
            }
        }
        for(int i=row+1;i<grid.length;i++){
            if(grid[i][column] == 1){
                return false;
            }
        }
        // check left diagonal
        for(int i=row-1,j=column-1;i>=0 && j>=0;i--,j--){
            if(grid[i][j] == 1){
                return false;
            }
        }
        for(int i=row+1,j=column+1;i<grid.length && j<grid.length;i++,j++){
            if(grid[i][j] == 1){
                return false;
            }
        }
        //check right
        for(int i=row-1,j=column+1;i>=0 && j<grid.length;i--,j++){
            if(grid[i][j] == 1){
                return false;
            }
        }
        for(int i=row+1,j=column-1;i<grid.length && j >=0;i++,j--){
            if(grid[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    private static void queens(int[][] grid,int r) {
        if(r>grid.length){
            return;
        }
        if(r == grid.length){
            for(int i =0;i<grid.length;i++){
                System.out.println(Arrays.toString(grid[i]));
            }
            System.out.println("------------------ "+ (++total));
            return;
        }
        int[] row = grid[r];
        for(int i=0;i<grid.length;i++){
            if(isSafe(grid,r,i)) {
                row[i] = 1;
                queens(grid, r + 1);
                row[i] = 0;
            }
        }
    }
}
