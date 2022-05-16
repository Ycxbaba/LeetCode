import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 */
public class Subsets {
	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] nums = {1,2,3};
		subsets.solution(nums);
	}

	//回溯
	public List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		back(ans,nums,-1,nums.length,new ArrayList<>());
		return ans;
	}

	private void back(List<List<Integer>> ans,int[] nums,int index,int len,List<Integer> member){
		if(index == len){
			return;
		}
		if(index != -1) member.add(nums[index]);
		ans.add(new ArrayList<>(member));
		back(ans,nums,index + 1,len,member);
		if(index != -1){
			member.remove(member.size() - 1);
			back(ans,nums,index + 1,len,member);
		};
	}

}
