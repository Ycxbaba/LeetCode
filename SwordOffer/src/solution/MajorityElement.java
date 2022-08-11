package solution;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		int t = 1;
		int num = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (t == 0)num = nums[i];
			if(nums[i] == num)t++;
			else t--;
		}
		return num;
	}
}
