package easy;

/**
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class MinStartValue {
	public int minStartValue(int[] nums) {
		int ans = 1;
		int sum = 1;
		for (int num : nums) {
			sum = sum + num;
			while (sum < 1) {
				ans++;
				sum++;
			}
		}
		return ans;
	}
}
