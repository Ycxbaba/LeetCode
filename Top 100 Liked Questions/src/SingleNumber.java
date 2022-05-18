/**
 * https://leetcode.cn/problems/single-number/
 */
public class SingleNumber {
	public static void main(String[] args) {

	}

	//位运算
	public int solution(int[] nums) {
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ans = ans ^ nums[i];
		}
		return ans;
	}
}
