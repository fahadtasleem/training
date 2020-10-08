package org.training.training_main.algo.array.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RobotGrid {
	static List<List<String>> listPaths = new LinkedList<List<String>>(); 
	static boolean isDiagonal = false; 
	
	public static int countPath(int[][] grid,int i,int j) {
		if((i==grid.length-1) && j == grid.length-1) {
			return 1;
		}
		if(i>=grid.length || j>=grid.length) {
			return 0;
		}
		if(grid[i][j]==1) {
			return 0;
		}
		return  countPath(grid, i, j+1) + countPath(grid, i+1, j)+ (isDiagonal?countPath(grid, i+1, j+1):0);
	}
	
	public static int countPathDynamic(int[][] grid,int i,int j) {
		int n = grid.length;
		int[][] paths = new int[grid.length][grid.length];
		//System.out.println(n+" --");
		for(int k=0;k<n;k++) {
			for(int l=0;l<n;l++) {
				if(l==0 && k==0) {
					continue;
				}
				if(grid[k][l] == 1) {
					paths[k][l] = 0;
					continue;
				}
				if(l==0 || k ==0) {
					paths[k][l] = 1;
					continue;
				}
				paths[k][l] = paths[k-1][l]+paths[k][l-1]+(isDiagonal?(paths[k-1][l-1]==0?1:paths[k-1][l-1]):0);
			}
		}
		
		return paths[n-1][n-1];
	}
	 
	
	public static int getPaths(int[][] grid,int i,int j,List<String> path) {
		path.add(i+","+j);
		if((i==grid.length-1) && j == grid.length-1) {
			listPaths.add(path);
			return 1;
		}
		if(i>=grid.length || j>=grid.length) {
			return 0;
		}
		List<String> path1 = new LinkedList<>(path);
		List<String> path2 = new LinkedList<>(path);
		return  getPaths(grid, i, j+1,path1) + getPaths(grid, i+1, j,path2);//+countPath(grid, i+1, j+1);
	}
	
	
	public static int costPathDynamic(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] paths = new int[grid.length][grid[0].length];
		//System.out.println(n+" --");
		paths[0][0] = grid[0][0];
		for(int i=1;i<m;i++)
			paths[0][i] = paths[0][i-1]+grid[0][i];
		for(int i=1;i<n;i++)
			paths[i][0] = paths[i-1][0]+grid[i][0];
		for(int k=1;k<n;k++) {
			for(int l=1;l<n;l++) {
				paths[k][l] = Math.min(paths[k-1][l],paths[k][l-1]) + grid[k][l];
			}
		}
		
		return paths[n-1][n-1];
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][]{
			{0,0,0},
			{0,0,1},
			{0,0,0}
		};
		System.out.println(countPath(grid,0,0));
		System.out.println(countPathDynamic(grid,0,0));
//		List<String> path = new LinkedList<>();
//		getPaths(grid,0,0,path);
//		System.out.println(listPaths.size());
//		for(List<String> l :listPaths) {
//			System.out.println(Arrays.toString(l.toArray()));
//		}
		int[][] costgrid = new int[][]{
			{1,1,1,1},
			{1,1,0,1},
			{9,1,1,1},
			{1,1,1,0},
//			{0,1,0,1},
//			{0,1,1,1}
		};
//		System.out.println("*************** Cost of min path");
//		System.out.println(costPathDynamic(costgrid));
		System.out.println(findlot(costgrid,4,4));
	}
	
	static int getMin(List<Integer> a) {
		int v = Integer.MAX_VALUE;
		boolean isFound = false;
		for(int i:a) {
			if(i==-1)
				continue;
			if(i<v) {
				isFound = true;
				v = i;
			}
		}
		return isFound?v:-1;
	}
	
	public static int findlot(int[][] lot,int numRows,int numColumns) {
		 int []x = {0,0,1,-1};//This represent 4 directions right, left, down , up
	        int []y = {1,-1,0,0};
	        int blockI = -1;
			int blockJ = -1;
	        LinkedList<Integer[]> q = new LinkedList();
	        q.add(new Integer[] {0,0});
	        int[][]dist = new int[numRows][numColumns];
	        for(int []a : dist){
	            Arrays.fill(a,-1);
	        }
	        dist[0][0] = 0;
	        while(!q.isEmpty()){
	            Integer[] p = q.removeFirst();
	            
	            for(int i = 0; i < 4; i++){
	                int a = p[0] + x[i];
	                int b = p[1] + y[i];
	                if(a >= 0 && b >= 0 && a < numRows && b < numColumns && dist[a][b] == -1 && lot[a][b] != 0 ){
	                	if(lot[a][b] == 9) {
	    					blockI = a;
	    					blockJ=b;
	    					continue;
	    				}
	                    dist[a][b] = 1 + dist[p[0]][p[1]];
	                    q.add(new Integer[] {a,b});
	                }
	            }
	        }
	        if(blockI != -1 && blockJ!=-1) {
				List<Integer> values = new ArrayList();
				if(blockI >0) {
					values.add(dist[blockI-1][blockJ]);
				}
				if(blockJ>0) {
					values.add(dist[blockI][blockJ-1]);
				}
				if(blockI < numRows-1) {
					values.add(dist[blockI+1][blockJ]);
				}
				if(blockJ<numColumns-1) {
					values.add(dist[blockI][blockJ+1]);
				}
				int m = getMin(values);
				System.out.println("=== "+m);
				return m;
			}
	        return -1;
	}
	

}
