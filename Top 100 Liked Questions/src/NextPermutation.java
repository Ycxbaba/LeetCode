import java.util.Arrays;

/**
 * https://leetcode.cn/problems/next-permutation/
 */
public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation nextPermutation = new NextPermutation();
		int[] ints = {1, 3, 2};
		nextPermutation.solution(ints);
		// Arrays.sort(ints,1,3);
		System.out.println(Arrays.toString(ints));
	}

	//时间复杂度 n 空间复杂度 1
	public void solution(int[] nums) {
		int i = nums.length -2;
		//保证从后向前都是升序
		while (i>=0 && nums[i] >= nums[i+1]){
			i--;
		}
		//找到不是升序的
		//开始二次遍历
		if(i>=0){
			int j = nums.length -1;
			//找到要替换的
			while (j>i && nums[j] <= nums[i]){
				j--;
			}
			//交换
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		//反转，交换后，i的后续是降序
		int end = nums.length -1;
		int start = i+1;
		while (start<end){
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			++start;
			--end;
		}
	}
}
