/**
 * https://leetcode.cn/problems/minimum-path-sum/
 */
public class MinPathSum {
	public static void main(String[] args) {

	}

	//动态规划
	public int solution1(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
			}
		}
		return dp[m-1][n-1];
	}

	//动态规划-----使用滚动数组
	public int solution2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//第一行
				if(i == 0 && j > 0){
					dp[j] = dp[j-1] + grid[0][j];
				}
				//第一列
				if (j == 0 && i > 0) {
					dp[j] = dp[j] + grid[i][0];
				}
				//其他
				if(j > 0 && i > 0){
					dp[j] = Math.min(dp[j],dp[j-1]) + grid[i][j];
				}
			}
		}
		return dp[n-1];
	}

}
