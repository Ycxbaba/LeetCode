package start;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 */
public class Permute {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(ans,new ArrayList<>(),nums, nums.length);
		return ans;
	}

	private void dfs(List<List<Integer>> ans,List<Integer> member,int[] nums,int len){
		if(member.size() == len){
			ans.add(new ArrayList<>(member));
		}
		for (int i = 0; i < len; i++) {
			if(member.contains(nums[i]))continue;
			member.add(nums[i]);
			dfs(ans,member,nums,len);
			member.remove(member.size() - 1);
		}
	}
}
