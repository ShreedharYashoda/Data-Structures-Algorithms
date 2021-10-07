// leetcode 785
import java.util.*;

class IsGraphBipartite {

	public static boolean isBipartite(int[][] graph){
		int n = graph.length;
		int[] color = new int[n];
		Arrays.fill(color, -1);

		Queue<Integer> q = new LinkedList<>();

		for(int start=0; start<n; start++){
			q.add(start);
			if(color[start] == -1) color[start] = 0;

			while(!q.isEmpty()){
				int cur = q.remove();
				for(int nbr:graph[cur]){
					if(color[nbr] == -1){
						color[nbr] = color[cur] ^ 1;
						q.add(nbr);
					}else if(color[nbr] == color[cur]){
						return false;
					}
				}
			}
		}

		return true;
		
	}

	public static void main(String[] args){
			System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
			System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
		}
}