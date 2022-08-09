package Sort;

import java.util.Arrays;

//十大排序
public class Solution {
	//冒泡排序
	private void bubbleSort(int[] nums){
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if(nums[j] > nums[j+1])swap(nums,j,j+1);
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	private void swap(int[] nums,int i,int j){
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.bubbleSort(new int[]{5,4,3,2,1,7,8});
	}
}
