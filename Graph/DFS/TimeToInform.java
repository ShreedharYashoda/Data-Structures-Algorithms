//Letcode 1376

import java.util.*;

class TimeToInform{
	
	public static int timeToInform(int n, int headId, int[] manager, int[] time){
		List<Integer>[] graph = new ArrayList[n];
		for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

		for(int i=0; i<manager.length; i++){
			if(manager[i] == -1) continue;

			graph[manager[i]].add(i);
		}

		return dfs(headId, graph, time);
	}

	public static int dfs(int mId, List<Integer>[] graph, int[] time){
		int maxTime = 0;

		for(int nbr:graph[mId]){
			maxTime = Math.max(maxTime, dfs(nbr, graph, time));
		}

		return maxTime + time[mId];
	}

	public static void main(String[] args){

		System.out.println(timeToInform(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0})); //3
		System.out.println(timeToInform(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914})); //1076
	}
}