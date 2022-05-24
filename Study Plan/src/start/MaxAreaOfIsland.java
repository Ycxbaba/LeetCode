package start;

/**
 *https://leetcode.cn/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null || grid.length == 0)return 0;
		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1){
					ans = Math.max(ans,dfs(grid, i, j));
				}
			}
		}
		return ans;
	}
	private int dfs(int[][] grid,int i,int j){
		if(grid[i][j] != 1)return 0;
		int count = 1;
		//标记已经被搜索过了
		grid[i][j] = 2;
		int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
		for (int[] ints : direct) {
			int newI = i + ints[0];
			int newJ = j + ints[1];
			if(newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length){
				count += dfs(grid,newI,newJ);
			}
		}
		return count;
	}
}
