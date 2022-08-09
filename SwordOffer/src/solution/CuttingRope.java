package solution;

/**
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
 */
public class CuttingRope {
	public int cuttingRope(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i - 1; j++) {
				int temp = Math.max(dp[j]*(i - j),j*(i-j));
				dp[i] = Math.max(temp,dp[i]);
			}
		}
		return dp[n];
	}
}
