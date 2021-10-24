//Leetcode 207
import java.util.*;

class CourseSchedule {

	boolean status;

	// Time O(N+E) 
	public boolean canFinish(int n, int[][] prereqs){
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] degree = new int[n];
		ArrayList<Integer> schedule = new ArrayList<>();

		for(int i=0; i<n; i++) graph.put(i, new ArrayList<>());

		for(int[] e:prereqs){
			graph.get(e[1]).add(e[0]);
			degree[e[0]]++;
		}

		for(int i=0; i<n; i++) if(degree[i]==0) schedule.add(i);

		for(int i=0; i<schedule.size(); i++){
			for(int j:graph.get(schedule.get(i))){
				if(--degree[j] == 0) schedule.add(j);
			}
		}

		return n == schedule.size();
	}


	public boolean isCyclic(int n, int[][] prereq) {
		status = false;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		boolean[] visited = new boolean[n];
		
		int[] cycle = new int[n];

		for(int i=0; i<n; i++) graph.put(i, new ArrayList<>());

		for(int[] e:prereq){
			graph.get(e[1]).add(e[0]);
		}

		for(int i=0; i<n; i++){
			if(!visited[i]) {
				dfs(i, graph, cycle, visited);
			}
		}

		return status;

	}

	public void dfs(int u, Map<Integer, List<Integer>> graph, int[] cycle, boolean[] visited) {
		visited[u] = true;

		cycle[u] = 1;

		for(int v:graph.get(u)) {
			if(cycle[v] == 1) {
				status = true;
				return;
			}

			if(!visited[v]) {
				dfs(v, graph, cycle, visited);
			}
		}

		cycle[u] = 0;
	}


	public static void main(String[] args){

		CourseSchedule cs = new CourseSchedule();

		System.out.println(cs.canFinish(4, new int[][]{{0,1},{0,2},{2,1},{3,1},{3,2}}));
		System.out.println(cs.canFinish(2, new int[][]{{1,0},{0,1}}));

		System.out.println(cs.isCyclic(4, new int[][]{{0,1},{0,2},{2,1},{3,1},{3,2}}));
		System.out.println(cs.isCyclic(2, new int[][]{{1,0},{0,1}}));
	}

}