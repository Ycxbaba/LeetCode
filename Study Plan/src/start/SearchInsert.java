package start;

/**
 * https://leetcode.cn/problems/search-insert-position/
 */
public class SearchInsert {
	public static void main(String[] args) {

	}
	public int searchInsert(int[] nums, int target) {
		int right = nums.length - 1;
		int left = 0;
		while (left <= right){
			int mid = (right + left)/2;
			if(target == nums[mid]){
				return mid;
			}
			if(target > nums[mid]){
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
}
