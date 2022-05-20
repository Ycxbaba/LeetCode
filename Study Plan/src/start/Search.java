package start;

/**
 * https://leetcode.cn/problems/binary-search/
 */
public class Search {
	public static void main(String[] args) {

	}
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right){
			int min = (left + right)/2;
			if(nums[min] == target){
				return min;
			}else if(nums[min] > target){
				right = min - 1;
			}else {
				left = min + 1;
			}
		}
		return -1;
	}
}
