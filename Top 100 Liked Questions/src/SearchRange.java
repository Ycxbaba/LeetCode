import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {
	public static void main(String[] args) {
		SearchRange searchRange = new SearchRange();
		int[] nums = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(searchRange.solution(nums, 8)));
	}

	//二分法
	//时间复杂度 log(n) 空间复杂度 1
	public int[] solution(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int[] ans = {-1, -1};
		while (left <= right){
			int mid = (left + right) / 2;
			if(nums[mid] == target){
				int temp = Math.max(mid - 1, 0);
				while (temp >= 0 && nums[temp] == target){
					temp --;
				}
				ans[0] = temp + 1;
				temp = Math.min(mid +1,nums.length - 1);
				while (temp <= nums.length - 1 && nums[temp] == target){
					temp++;
				}
				ans[1] = temp -1;
				break;
			}else if(nums[mid]  > target){
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		return ans;
	}
}
