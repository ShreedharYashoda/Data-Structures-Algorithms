//Leetcode 210

import java.util.*;

class CourseScheduleII {

	public static List<Integer> findOrder(int n, int[][] edges){
				ArrayList<Integer>[] graph = new ArrayList[n];
        int[] degree = new int[n];
        List<Integer> order = new ArrayList<>();
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e:edges){
            graph[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        
        for(int i=0; i<n; i++) if(degree[i] == 0) order.add(i);
        
        for(int i=0; i<order.size(); i++){
            for(int j:graph[order.get(i)]){
                if(--degree[j] == 0) order.add(j);
            }
        }

				return n == order.size() ? order : new ArrayList<>();
	}

	public static void main(String[] args){
		System.out.println(findOrder(4, new int[][]{{0,1},{0,2},{2,1},{3,1},{3,2}}));
		System.out.println(findOrder(2, new int[][]{{1,0},{0,1}}));
	}
	
}