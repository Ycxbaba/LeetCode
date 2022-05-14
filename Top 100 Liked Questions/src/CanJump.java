/**
 * https://leetcode.cn/problems/jump-game/
 */
public class CanJump {
	public static void main(String[] args) {
		CanJump canJump = new CanJump();
		int[] nums = {3,2,2,0,4};
		System.out.println(canJump.solution(nums));
	}

	//贪心算法
	public boolean solution(int[] nums) {
		int len = nums.length;
		int maxLen = 0;
		for (int i = 0; i < len; i++) {
			if(i<=maxLen){
				maxLen = Math.max(maxLen,i+nums[i]);
			}
			if(maxLen >= len - 1){
				return true;
			}
		}
		return false;
	}
}
