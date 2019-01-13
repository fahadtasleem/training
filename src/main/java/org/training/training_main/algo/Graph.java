package org.training.training_main.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 * 
 * @author fahad
 *
 */
public class Graph {
	int v;
	List<Integer>[] edges;

	public Graph(int v) {
		this.v = v;
		edges = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			edges[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int v, int e) {
		edges[v].add(e);
	}

	void dfsUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v+" ");
		List<Integer> adjs = edges[v];
		for(int adj: adjs) {
			if(!visited[adj]) {
				dfsUtil(adj, visited);
			}
		}
	}
	
	void dfs(int v) {
		boolean visited[] = new boolean[this.v];
		Arrays.fill(visited, false);
		dfsUtil(v,visited);
	}
	
	void bfs(int v) {
		boolean visited[] = new boolean[this.v];
		Arrays.fill(visited, false);
		visited[v] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		System.out.println("");
		while(queue.size()!=0) {
			v = queue.poll();
			visited[v] = true;
			System.out.print(v+" ");
			List<Integer> adjs = edges[v];
			for(int adj: adjs) {
				if(!visited[adj]) {
					queue.add(adj);
				}
			}
		}
	}
	
	int countPaths(int s, int d) {
		boolean visited[] = new boolean[this.v];
		Arrays.fill(visited, false);
		return countPathUtils(s,d,visited,0);
	}
	
	private int countPathUtils(int s, int d, boolean[] visited, int pathCount) {
		visited[s] = true;
		if(s == d) {
			pathCount++;
		}
		List<Integer> adjs = edges[s];
		for(int adj : adjs) {
			if(!visited[adj])
				pathCount = countPathUtils(adj, d, visited, pathCount);
		}
		visited[s] = false;
		return pathCount;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.dfs(2);
        g.bfs(2);
        
        g = new Graph(4); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(2, 0); 
        g.addEdge(2, 1); 
        g.addEdge(1, 3); 
        System.out.println("");
        int s = 2, d = 3; 
        System.out.println(g.countPaths(s, d)); 
	}
}
