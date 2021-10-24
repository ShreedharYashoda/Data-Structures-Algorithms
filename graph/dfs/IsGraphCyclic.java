import java.util.*;

class IsGraphCyclic {

	public boolean isGraphCyclic(int u, Map<Integer, List<Integer>> g, boolean[] visited, int parent) {
		visited[u] = true;

		for(int v:g.get(u)) {
			if(!visited[v]) {
				if(isGraphCyclic(v, g, visited, u)){
					return true;
				} 
			}else if(v != parent) {
			return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] edges = {{0,1},{2,3}};
		int n = 4;

		Map<Integer, List<Integer>> undirectedGraph = new HashMap<>();

		for(int i=0; i<n; i++) undirectedGraph.put(i, new ArrayList());

		for(int[] e:edges) {
			undirectedGraph.get(e[0]).add(e[1]);
			undirectedGraph.get(e[1]).add(e[0]);
		}

		IsGraphCyclic instance = new IsGraphCyclic();
		boolean[] visited = new boolean[n];
		if(instance.isGraphCyclic(0, undirectedGraph, visited, -1)) {
			System.out.println("It's cyclic");
		}else{
			System.out.println("It's not cyclic");
		}
		
	}
}