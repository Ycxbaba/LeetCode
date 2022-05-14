/**
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class MaxSubArray {
	public static void main(String[] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int solution = maxSubArray.solution(nums);
		System.out.println(solution);
	}

	public int solution(int[] nums) {
		int pre = 0 , ans = nums[0];
		for (int num : nums){
			pre = Math.max(pre + num, num);
			ans = Math.max(ans,pre);
		}
		return ans;
	}
}
