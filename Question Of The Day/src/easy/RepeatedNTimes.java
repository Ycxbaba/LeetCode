package easy;

import java.util.HashSet;
import java.util.Random;

/**
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class RepeatedNTimes {
	public static void main(String[] args) {

	}
	public int repeatedNTimes(int[] nums) {
		HashSet<Integer> integers = new HashSet<>();
		for (int num : nums) {
			if(integers.contains(num))return num;
			else integers.add(num);
		}
		return -1;
	}
	public int solution2(int[] nums) {
		int n = nums.length;
		Random random = new Random();
		while (true) {
			int x = random.nextInt(n), y = random.nextInt(n);
			if (x != y && nums[x] == nums[y]) {
				return nums[x];
			}
		}
	}
}
