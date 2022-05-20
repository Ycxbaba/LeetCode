package medium;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinMoves2 {
	public static void main(String[] args) {
		MinMoves2 minMoves2 = new MinMoves2();
		int[] nums = {1,0,0,8,6};
		System.out.println(minMoves2.minMoves2(nums));
	}
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int ans = 0;
		int n = nums[nums.length/2];
		for (int num : nums) {
			ans += Math.abs(num - n);
		}
		return ans;
	}
}

