import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindDisappearedNumbers {
	//这种思想要理解
	public List<Integer> solution(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int n = nums.length;
		for (int num : nums) {
			// -1 防止溢出
			int x = (num - 1)% n;
			nums[x] += n;
		}
		for (int i = 0; i < n; i++) {
			if(nums[i] <= n){
				list.add(i+1);
			}
		}
		return list;
	}
}
