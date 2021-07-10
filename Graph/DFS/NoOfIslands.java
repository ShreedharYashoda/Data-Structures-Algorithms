class NoOfIslands{

	public static int getIslands(int[][] grid){
		if(grid.length == 0 || grid == null) return 0;
		int R = grid.length, C = grid[0].length;
		int count = 0;

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(grid[i][j] == 1){
					count++;
					dfs(i, j, grid);
				}
			}
		}

		return count;
	}

	public static void dfs(int i, int j, int[][] grid){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
			return;
		}
		grid[i][j] = 0;
		dfs(i, j+1, grid);
		dfs(i, j-1, grid);
		dfs(i+1, j, grid);
		dfs(i-1, j, grid);
	
	}

	public static void main(String[] args){
		int[][] grid = {{1,1,0,0,1},
		{1,0,0,0,0},
		{0,0,1,0,0},
		{0,1,0,1,1},
		{0,0,0,1,1}};
		
		System.out.println(getIslands(grid));
	}
}