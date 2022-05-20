/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 */
public class MaxProduct {
	public static void main(String[] args) {

	}

	public int solution(int[] nums) {
		int len = nums.length;
		int[] max = new int[len];
		int[] min = new int[len];
		max[0] = nums[0];
		min[0] = nums[0];
		int ans = max[0];
		for (int i = 1; i < len; i++) {
			//考虑下一个是否为正的问题，要记录前 i-1 个数的最小乘积 ,
			//      如果当前为负 那么最大值可能为 之前最小的乘积 与 num[i](负数) 的乘积
			//      如果当前为正 那么更新max[] 继续记录min[]
			max[i] = Math.max(max[i-1] * nums[i],Math.max(min[i-1] * nums[i],nums[i]));
			min[i] = Math.min(min[i-1] * nums[i],Math.min(max[i-1] * nums[i],nums[i]));
			ans = Math.max(max[i],ans);
		}
		return ans;
	}

}
