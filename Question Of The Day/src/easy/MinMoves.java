package easy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/
 */
public class MinMoves {
	public static void main(String[] args) {

	}
	public int minMoves(int[] nums) {
		int min = nums[0];
		int ans = 0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] < min){
				ans = ans + i * (min - nums[i]);
				min = nums[i];
			}else {
				ans = ans + (nums[i] - min);
			}
		}
		return ans;
	}
}
