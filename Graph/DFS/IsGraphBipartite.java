//Leetcode 785
import java.util.*;

class IsGraphBipartite {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        boolean ans = true;
        
        for(int start = 0; start<n; start++){
            if(color[start] == -1){
                color[start] = 0;
                ans = ans && dfs(start, color, graph);
            }
        }
        
        return ans;
    }
    
    public static boolean dfs(int node, int[] color, int[][] graph){
        boolean isBip = true;
        for(int nbr:graph[node]){
            if(color[nbr] == -1){
                color[nbr] = color[node] ^ 1;
                isBip &= dfs(nbr, color, graph);
            }else if(color[node] == color[nbr]){
                return false;
            }
        }
        
        return isBip;
    }

		public static void main(String[] args){
			// [[1,2,3],[0,2],[0,1,3],[0,2]]
			System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));

			System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
		}
}