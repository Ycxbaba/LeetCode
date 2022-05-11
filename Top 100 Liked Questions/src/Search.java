/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
public class Search {
	public static void main(String[] args) {

	}

	//时间复杂度 log(n) 空间复杂度 1
	public int solution(int[] nums, int target) {
		int n = nums.length;
		if (n == 0) {
			return -1;
		}
		if (n == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int l = 0, r = n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[0] <= nums[mid]) {
				//左边有序 右边无序
				if (nums[0] <= target && target < nums[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				//右边有序 左边无序
				if (nums[mid] < target && target <= nums[n - 1]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}
}
