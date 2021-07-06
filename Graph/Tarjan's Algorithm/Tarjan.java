import java.util.*;
class Tarjan{

	List<Integer>[] graph;
	int[] lowlink;
	boolean[] visited;
	Stack<Integer> stack;
	int time = 0;
	List<List<Integer>> components;

	public List<List<Integer>> scc(List<Integer>[] graph){
		int n = graph.length;
		this.graph = graph;
		
		lowlink = new int[n];
		visited = new boolean[n];
		stack = new Stack<>();
		components = new ArrayList<>();

		for(int i=0; i<n; i++){
			if(!visited[i])
				dfs(i);
		}

		return components;
	} 

	public void dfs(int u){
		visited[u] = true;
		lowlink[u] = time++;
		stack.add(u);
		boolean isComponentRoot = true;

		for(int v:graph[u]){
			if(!visited[v]){
				dfs(v);
			}
			if(lowlink[u] > lowlink[v]){
				lowlink[u] = lowlink[v];
				isComponentRoot = false;
			}
		}

		if(isComponentRoot){
			List<Integer> component = new ArrayList<>();
			while(true){
				int x = stack.pop();
				component.add(x);
				lowlink[x] = Integer.MAX_VALUE;
				if(x == u){
					break;
				}
			}
			components.add(component);
		}
	}


	public static void main(String[] args) {
    List<Integer>[] g = new List[3];
    for (int i = 0; i < g.length; i++)
      g[i] = new ArrayList<>();

    g[2].add(0);
    g[2].add(1);
    g[0].add(1);
    g[1].add(0);

    
		List<List<Integer>> components = new Tarjan().scc(g);
		System.out.println(components);
  }
}