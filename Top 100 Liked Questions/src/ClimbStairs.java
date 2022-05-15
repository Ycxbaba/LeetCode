/**
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class ClimbStairs {
	public static void main(String[] args) {

	}

	public int solution1(int n) {
		if(n == 0)return 0;
		if(n == 1)return 1;
		if(n == 2)return 2;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n-1];
	}

	//动态规划----滚动数组
	public int solution2(int n) {
		int pre1 = 0 , pre2 = 0 , ans = 1;
		for (int i = 0; i < n; i++) {
			pre2 = pre1;
			pre1 = ans;
			ans = pre1 + pre2;
		}
		return ans;
	}

	//数学法 ----直接求n项
	public int solution3(int n) {
		double sqrt5 = Math.sqrt(5.0);
		double f = Math.pow((1+sqrt5)/2,n+1) - Math.pow((1-sqrt5)/2,n+1);
		return (int)Math.abs(f/sqrt5);
	}

}
