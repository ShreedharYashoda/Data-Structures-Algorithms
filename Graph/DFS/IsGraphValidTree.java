
// Leetcode 261
import java.util.*;
class IsGraphValidTree{

	private static List<List<Integer>> graph;
	private static Set<Integer> seen;

	public static boolean isValidTree(int n, int[][] edges){
		
		if(n-1 != edges.length) return false;

		graph = new ArrayList<>();
		seen = new HashSet<>();

		for(int i=0; i<n; i++){
			graph.add(new ArrayList());
		}

		for(int[] e:edges){
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		dfs(0);

		return seen.size() == n;

	}

	public static void dfs(int node){
		if(seen.contains(node)) return;
		seen.add(node);
		for(int n:graph.get(node)){
			dfs(n);
		}
	}

	public static void main(String[] args){
		int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}}; // tree 
		int[][] edges2 = {{0,1},{1,2},{2,3},{1,3},{1,4}}; // Not a tree
		int[][] edges3 = {{0,1},{0,4},{1,4},{2,3}};   //Two components

		System.out.println(isValidTree(5, edges1));
		System.out.println(isValidTree(5, edges2));
		System.out.println(isValidTree(5, edges3));
	}
}