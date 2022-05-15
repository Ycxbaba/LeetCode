/**
 * https://leetcode.cn/problems/edit-distance/
 */
public class MinDistance {
	public static void main(String[] args) {

	}

	public int solution(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		//有一个为0
		if(len1 * len2 == 0){
			return len1 + len2;
		}
		int[][] dp = new int[len1 + 1][len2 + 1];
		//初始化
		for (int i = 0; i < len1 + 1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < len2 + 1; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1)
						? Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]))
						: Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
			}
		}
		return dp[len1][len2];
	}
}
