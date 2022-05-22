import java.util.Arrays;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {
	/**
	 * [1,2,3,4]
	 * [-1,1,0,-3,3]
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {-1,1,0,-3,3};
		ProductExceptSelf productExceptSelf = new ProductExceptSelf();
		System.out.println(Arrays.toString(productExceptSelf.solution1(nums)));
	}
	//坑爹 没看清题目 要求不能使用除法
	public int[] solution1(int[] nums) {
		int[] ans = new int[nums.length];
		int total = 1;
		int zeroCount = 0;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0){
				index = i;
				zeroCount ++;
				if(zeroCount == 2){
					break;
				}
				continue;
			}
			total *= nums[i];
		}
		if(zeroCount == 0){
			for (int i = 0; i < nums.length; i++) {
				ans[i] = total / nums[i];
			}
			return ans;
		}
		if(zeroCount == 1){
			ans[index] = total;
			return ans;
		}
		return ans;
	}

	//左右相乘
	public int[] solution2(int[] nums){
		int len = nums.length;
		int[] L = new int[len];
		int[] R = new int[len];
		int[] ans = new int[len];
		L[0] = 1;
		R[len - 1] = 1;
		for (int i = 1; i < len; i++) {
			L[i] = L[i-1] * nums[i-1];
			R[len - 1 -i] = R[len -i] * nums[len-i];
		}
		for (int i = 0; i < len; i++) {
			ans[i] = L[i] * R[i];
		}
		return ans;
	}
	//空间复杂度为1
	public int[] solution3(int[] nums){
		int len = nums.length;
		int[] ans = new int[len];
		ans[0] = 1;
		for (int i = 1; i < len; i++) {
			ans[i] = ans[i-1] * nums[i-1];
		}
		int R = 1;
		for (int i = len - 1; i >= 0; i--) {
			ans[i] = ans[i] * R;
			R = R * nums[i];
		}
		return ans;
	}
}
