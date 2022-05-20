package start;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {-1,-1,1};
		TwoSum twoSum = new TwoSum();
		System.out.println(Arrays.toString(twoSum.twoSum(nums, -2)));
	}
	//二分
	public int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
		int left = 0,right = len - 1;
		for (int i = 0; i < len; i++) {
			// if(numbers[i] <= target){
				left = i + 1;
				int t = target - numbers[i];
				while (left <= right){
					int mid = (left + right)/2;
					if(numbers[mid] == t){
						return new int[]{i+1,mid+1};
					}else if(numbers[mid] > t){
						right = mid - 1;
					}else {
						left = mid + 1;
					}
				}
			// }
		}
		return null;
	}
	//双指针
	public int[] solution(int[] numbers, int target) {
		int left = 0 , right = numbers.length - 1;
		while (left < right){
			int sum = numbers[left] + numbers[right];
			if(sum > target){
				--right;
			}else if (sum < target){
				++left;
			}else {
				return new int[]{left+1,right+1};
			}
		}
		return new int[] {-1,-1};
	}
}
