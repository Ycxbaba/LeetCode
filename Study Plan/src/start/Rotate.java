package start;

/**
 * https://leetcode.cn/problems/rotate-array/
 */
public class Rotate {
	public static void main(String[] args) {

	}
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		reserve(0,nums.length - 1,nums);
		reserve(0,k-1,nums);
		reserve(k,nums.length - 1,nums);
	}
	private void reserve(int start,int end,int[] nums){
		for (int i = start, j = end; i < j; i++,j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
