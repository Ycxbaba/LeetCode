package medium;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/matchsticks-to-square/
 */
public class MakeSquare {
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2};
		MakeSquare makeSquare = new MakeSquare();
		makeSquare.solution2(nums);
	}

	public boolean solution(int[] matchsticks) {
		int totalLen = Arrays.stream(matchsticks).sum();
		if (totalLen % 4 != 0) {
			return false;
		}
		Arrays.sort(matchsticks);
		for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
			int temp = matchsticks[i];
			matchsticks[i] = matchsticks[j];
			matchsticks[j] = temp;
		}

		int[] edges = new int[4];
		return dfs(0, matchsticks, edges, totalLen / 4);
	}

	public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
		if (index == matchsticks.length) {
			return true;
		}
		for (int i = 0; i < edges.length; i++) {
			edges[i] += matchsticks[index];
			if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
				return true;
			}
			edges[i] -= matchsticks[index];
		}
		return false;
	}

	public boolean solution2(int[] matchsticks) {
		int totalLen = Arrays.stream(matchsticks).sum();
		if (totalLen % 4 != 0) {
			return false;
		}
		int len = totalLen / 4, n = matchsticks.length;
		int[] dp = new int[1 << n];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int s = 1; s < (1 << n); s++) {
			for (int k = 0; k < n; k++) {
				if ((s & (1 << k)) == 0) {
					continue;
				}
				int s1 = s & ~(1 << k);
				if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
					dp[s] = (dp[s1] + matchsticks[k]) % len;
					break;
				}
			}
		}
		return dp[(1 << n) - 1] == 0;
	}

}
