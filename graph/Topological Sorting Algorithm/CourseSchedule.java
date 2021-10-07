//Leetcode 207
import java.util.*;

class CourseSchedule {

	// Time O(N+E) 
	public static boolean canFinish(int n, int[][] prereqs){
		ArrayList<Integer>[] graph = new ArrayList[n];
		int[] degree = new int[n];
		ArrayList<Integer> schedule = new ArrayList<>();

		for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

		for(int[] e:prereqs){
			graph[e[1]].add(e[0]);
			degree[e[0]]++;
		}

		for(int i=0; i<n; i++) if(degree[i]==0) schedule.add(i);

		for(int i=0; i<schedule.size(); i++){
			for(int j:graph[schedule.get(i)]){
				if(--degree[j] == 0) schedule.add(j);
			}
		}

		return n==schedule.size();
	}


	public static void main(String[] args){
		System.out.println(canFinish(4, new int[][]{{0,1},{0,2},{2,1},{3,1},{3,2}}));
		System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
	}
}