import java.util.*;

class TopologicalSorting{

	List<Integer>[] graph;
	boolean[] visited;
	List<Integer> res;

	public List<Integer> topologicalSorting(List<Integer>[] graph){
			int n = graph.length;
			this.graph = graph;
			visited = new boolean[n];
			res = new ArrayList<>();

			for(int u=0; u<n; u++){
				if(!visited[u]){
					dfs(u);
				}
			}
			Collections.reverse(res);
			return res;
	}

	public void dfs(int u){
		visited[u] = true;
		for(int v:graph[u]){
			if(!visited[v]) dfs(v);
		}
		res.add(u);
		//System.out.println(res);
	}


	public static void main(String[] args) {
    int n = 4;
		int[][] edges = {{0,1},{0,2},{2,1},{3,1},{3,2}};

		List<Integer>[] g = new ArrayList[n];
		for(int i=0; i<n; i++){
			g[i] = new ArrayList<>();
		}

		for(int[] e:edges){
			g[e[0]].add(e[1]);
		}

		TopologicalSorting ts = new TopologicalSorting();
		System.out.println(ts.topologicalSorting(g));
  }
}