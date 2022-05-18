import java.util.Arrays;

/**
 * https://leetcode.cn/problems/majority-element/
 */
public class MajorityElement {
	public static void main(String[] args) {

	}

	public int solution1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	public int solution2(int[] nums) {
		int ans = 0, count = 0;
		for (int num : nums) {
			if (count == 0) {
				ans = num;
				count++;
			} else if (ans != num) {
				count--;
			} else {
				count++;
			}
		}
		return ans;
	}
}
