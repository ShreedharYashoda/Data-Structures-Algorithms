// LeetCode 695

import java.util.*;

class MaxAreaOfIsland{

	public static int getMaxAreaOfIsland(int[][] grid){
		if(grid.length == 0 || grid == null) return 0;
		int R = grid.length, C = grid[0].length;

		int area = 0;
		int maxArea = 0;
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(grid[i][j] == 1){
					area = 0;
					area = dfs(i,j,grid,0);
					maxArea = Math.max(maxArea, area);
				}
			}
		}

		// System.out.println(islands);
		return maxArea;
	}

	public static int dfs(int i, int j, int[][] grid, int a){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
			return 0;
		}
		grid[i][j] = 0;
		int right = dfs(i, j+1, grid, a);
		int left = dfs(i, j-1, grid, a);
		int down = dfs(i+1, j, grid, a);
		int up = dfs(i-1, j, grid, a);

		return 1+right+left+down+up;
	
	}

	public static void main(String[] args){
		int[][] grid = {
		{1,1,0,0,1},
		{1,0,0,0,0},
		{0,0,1,0,1},
		{0,1,0,1,1},
		{0,0,1,1,1}};
		
		System.out.println(getMaxAreaOfIsland(grid));
	}
}