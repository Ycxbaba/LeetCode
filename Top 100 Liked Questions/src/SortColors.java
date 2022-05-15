/**
 * https://leetcode.cn/problems/sort-colors/
 */
public class SortColors {
	public static void main(String[] args) {
		SortColors sortColors = new SortColors();
		int[] nums = {1,0,1,2,0,1,0,2,1,1,2,0};
		sortColors.solution4(nums);
	}

	//三指针 妙啊
	public void solution1(int[] nums) {
		int num0 = 0 , num1 = 0 , num2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0){
				nums[num2++] = 2;
				nums[num1++] = 1;
				nums[num0++] = 0;
			}else if(nums[i] == 1){
				nums[num2++] = 2;
				nums[num1++] = 1;
			}else {
				nums[num2++] = 2;
			}
		}

	}

	//单指针
	public void solution2(int[] nums) {
		int ptr = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0){
				nums[i] = nums[ptr];
				nums[ptr++] = 0;
			}
		}
		for (int i = ptr; i < nums.length; i++) {
			if(nums[i] == 1){
				nums[i] = nums[ptr];
				nums[ptr++] = 1;
			}
		}
	}

	//双指针
	public void solution3(int[] nums) {
		int ptr1 = 0 , ptr2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1){
				// 1 与 2 交换
				nums[i] = nums[ptr2];
				nums[ptr2++] = 1;
			}
			if(nums[i] == 0){
				//1 与 0 交换
				nums[i] = nums[ptr1];
				nums[ptr1] = 0;
				if(ptr2 > ptr1){
					// 1 与 2 交换
					int temp = nums[ptr2];
					nums[ptr2] = nums[i];
					nums[i] = temp;
				}
				ptr1 ++;
				ptr2 ++;
			}
		}
	}

	//双指针
	public void solution4(int[] nums) {
		int ptr1 = 0 , ptr2 = nums.length - 1;
		for (int i = 0; i <= ptr2 ; i++) {
			while (nums[i] == 2 && i <= ptr2){
				nums[i] = nums[ptr2];
				nums[ptr2--] = 2;
			}
			if(nums[i] == 0){
				nums[i] = nums[ptr1];
				nums[ptr1++] = 0;
			}
		}
	}

}
