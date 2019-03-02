package org.training.training_main.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
	/**
	 * Find pairs whose some is equal to x.
	 * @param arr
	 * @param n
	 * @param sum
	 * @return
	 */
	static int getPairsCount(int arr[],int n, int sum) 
    { 
        HashMap<Integer, Integer> hm = new HashMap<>(); 
  
        // Store counts of all elements in map hm 
        for (int i=0; i<n; i++){ 
              
            // initializing value to 0, if key not found 
            if(!hm.containsKey(arr[i])) 
                hm.put(arr[i],0); 
                  
            hm.put(arr[i], hm.get(arr[i])+1); 
        } 
        int twice_count = 0; 
  
        // iterate through each element and increment the 
        // count (Notice that every pair is counted twice) 
        for (int i=0; i<n; i++) 
        { 
            if(hm.get(sum-arr[i]) != null) 
                twice_count += hm.get(sum-arr[i]); 
  
            // if (arr[i], arr[i]) pair satisfies the condition, 
            // then we need to ensure that the count is 
            // decreased by one such that the (arr[i], arr[i]) 
            // pair is not considered 
            if (sum-arr[i] == arr[i]) 
                twice_count--; 
        } 
  
        // return the half of twice_count 
        return twice_count/2; 
    } 
	public static void path(List<Edge>[] edges,boolean[] visited,List<Edge> path,List<Integer> vs){
		List<Edge> edge = new LinkedList<Edge>();
		if(vs.size() == edges.length-1) {
			return;
		}
        Edge smallest = null;
        for(Integer v: vs){
            List<Edge> ve = edges[v];
            for(Edge e:ve) {
	            if(!e.visited && (smallest==null || smallest.w >e.w)){
	            	if( !vs.contains(e.v)) {	                	
	            		smallest = e;
	                }
	                
	            }
            }
        }
        if(smallest!=null) {
	        smallest.visited = true;
	        path.add(smallest);
	        vs.add(smallest.v);
	        path(edges,visited,path,vs);
        }
    }
    
    public static void findPath(List<Edge>[] edges,int start){
        boolean[] visited = new boolean[edges.length];
        Arrays.fill(visited,false);
        visited[start] = true;
        List<Edge> path = new LinkedList<Edge>();
        List<Integer> vs = new LinkedList<Integer>();
        vs.add(start);
        path(edges,visited,path,vs);
        for(Edge e:path) {
        	System.out.print(e.w+" ");
        }
        System.out.println("************************ ");
    }
    public static class Edge{
        int v;
        int w;
        boolean visited = false;
        public Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            
            int v = sc.nextInt();
            int c = sc.nextInt();
            List<Edge>[] edges = new LinkedList[v+1];
            for (int i = 0; i <= v; ++i)
			    edges[i] = new LinkedList<Edge>();
            boolean[] visited = new boolean[v];
            for (int i = 0; i < c; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int w = sc.nextInt();
                //System.out.println(v1+" "+v2+" w"+w);
                edges[v1].add(new Edge(v2,w));
                edges[v2].add(new Edge(v1,w));
            }
            int start = sc.nextInt();
            findPath(edges,start);
            
        }
    }
}
/*
9 23
1 1 1
1 2 2
1 7 3
1 9 4
2 1 5
2 3 6
3 7 7
3 8 8
4 5 9
4 9 10
5 2 11
5 3 12
5 5 13
5 7 14
6 1 15
6 2 16
6 5 17
7 7 18
7 8 19
8 5 20
8 9 21
9 3 22
9 7 23
9
*/
