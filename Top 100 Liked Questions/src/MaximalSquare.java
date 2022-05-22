public class MaximalSquare {
	public static void main(String[] args) {

	}
	public int maximalSquare(char[][] matrix) {
		int r = matrix.length,c = matrix[0].length;
		int[][] dp = new int[r][c];
		dp[0][0] = parse(matrix[0][0]);
		int ans = dp[0][0];
		for (int i = 1; i < r; i++) {
			dp[i][0] = parse(matrix[i][0]);
			ans = Math.max(ans,dp[i][0]);
		}
		for (int j = 1; j < c; j++) {
			dp[0][j] = parse(matrix[0][j]);
			ans = Math.max(ans,dp[0][j]);
		}
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if(matrix[i][j] == '1'){
					dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
					ans = Math.max(ans,dp[i][j]);
				}
			}
		}
		return ans*ans;
	}

	private int parse(char c){
		return c == '1' ? 1 : 0;
	}
}
