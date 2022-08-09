package solution;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {
	public int findRepeatNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)){
				return num;
			}
			set.add(num);
		}
		return -1;
	}

	/**
	 * 将每一个元素都放到自己的位置上，如果发现自己的位置被占，说明重复
	 * @param nums
	 * @return
	 */
	public int findRepeatNumber2(int[] nums) {
		if(nums.length == 0)return -1;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i){
				if(nums[i] == nums[nums[i]]){
					return nums[i];
				}
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return -1;
	}
}
