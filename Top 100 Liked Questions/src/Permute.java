import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 */
public class Permute {
	public static void main(String[] args) {
		Permute permute = new Permute();
		int[] nums = {1,2,3};
		List<List<Integer>> solution = permute.solution(nums);
	}

	public List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(ans,new ArrayList<>(),nums.length,nums);
		return ans;
	}

	private void dfs(List<List<Integer>> ans,List<Integer> member,int len,int[] nums){
		if(member.size() == len){
			ans.add(new ArrayList<>(member));
			return;
		}
		for (int i = 0; i < len; i++) {
			if(member.contains(nums[i]))continue;
			member.add(nums[i]);
			dfs(ans,member,len,nums);
			member.remove(member.size() - 1);
		}
	}
}
