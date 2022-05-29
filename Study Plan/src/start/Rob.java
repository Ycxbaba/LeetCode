package start;

/**
 * https://leetcode.cn/problems/house-robber/
 */
public class Rob {
	public int rob(int[] nums) {
		if(nums.length == 1)return nums[0];
		if(nums.length == 2)return Math.max(nums[0],nums[1]);
		int dp = 0;
		int dp0 = nums[0];
		int dp1 = Math.max(nums[0],nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp = Math.max(dp1,dp0 + nums[i]);
			dp0 = dp1;
			dp1 = dp;
		}
		return dp;
	}
}
