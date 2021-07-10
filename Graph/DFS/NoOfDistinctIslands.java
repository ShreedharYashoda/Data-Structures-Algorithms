// LeetCode 694

import java.util.*;

class NoOfDistinctIslands{

	public static int getDistinctIslands(int[][] grid){
		if(grid.length == 0 || grid == null) return 0;
		int R = grid.length, C = grid[0].length;

		Set<String> islands = new HashSet<>();

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(grid[i][j] == 1){
					islands.add(dfs(i, j, grid, "x"));
				}
			}
		}

		// System.out.println(islands);
		return islands.size();
	}

	public static String dfs(int i, int j, int[][] grid, String s){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
			return "0";
		}
		grid[i][j] = 0;
		String right = dfs(i, j+1, grid, "R");
		String left = dfs(i, j-1, grid, "L");
		String down = dfs(i+1, j, grid, "D");
		String up = dfs(i-1, j, grid, "U");

		return s+right+left+down+up;
	
	}

	public static void main(String[] args){
		int[][] grid = {
		{1,1,0,0,1},
		{1,0,0,0,0},
		{0,0,1,0,0},
		{0,1,0,1,1},
		{0,0,0,1,1}};
		
		System.out.println(getDistinctIslands(grid));
	}
}