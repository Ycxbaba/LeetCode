package start;

/**
 * https://leetcode.cn/problems/move-zeroes/
 */
public class MoveZeroes {
	public static void main(String[] args) {

	}
	public void moveZeroes(int[] nums) {
		int first = 0 ,second = 0;
		while (first < nums.length){
			if(nums[first] != 0){
				int temp = nums[first];
				nums[first] = nums[second];
				nums[second] = temp;
				second++;
			}
			first ++;
		}
	}

	public void solution(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0){
				nums[index] = nums[i];
				index++;
			}
		}
		for (int i = index; i < nums.length; i++) {
			nums[index] = 0;
		}
	}

}
