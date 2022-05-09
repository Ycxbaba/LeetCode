import java.util.*;

/**
 * https://leetcode.cn/problems/3sum/
 */
public class ThreeSum {

	public static void main(String[] args) {

	}

	//排序 + 双指针
	//时间复杂度 n*n 空间复杂度 log(n) ---->排序导致的
	public List<List<Integer>> solution(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if(i>0 && nums[i] == nums[i-1]){
				continue;
			}
			int target = -nums[i];
			int k = n - 1;
			for (int j = i + 1; j < n; j++) {
				if(j > i+1 && nums[j] == nums[j-1]){
					continue;
				}
				while (j < k && nums[j] + nums[k] > target){
					--k;
				}

				if (j == k) {
					break;
				}

				if(nums[j] + nums[k] == target){
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					ans.add(temp);
				}
			}
		}
		return ans;
	}
}
