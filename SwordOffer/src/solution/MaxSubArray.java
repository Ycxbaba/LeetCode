package solution;

/**
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int pre = nums[0];
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			pre = Math.max(pre + num, num);
			max = Math.max(max, pre);
		}
		return max;
	}
}
