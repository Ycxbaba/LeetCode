import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 */
public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum combinationSum = new CombinationSum();
		int[] candidates = {2,3,6,7};
		// List<List<Integer>> solution = combinationSum.solution1(candidates, 7);
		// List<List<Integer>> solution = combinationSum.solution2(candidates, 7);
		List<List<Integer>> solution = combinationSum.solution3(candidates, 7);
		System.out.println(solution);

	}

	//回溯法
	public List<List<Integer>> solution1(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		back1(ans,0,target,new ArrayList<>(),candidates);
		return ans;
	}

	//无剪枝 从后往前去重
	private void back1(List<List<Integer>> ans , int index , int target , List<Integer> member , int[] candidates){
		if(index == candidates.length){
			return;
		}

		if(target == 0){
			ans.add(new ArrayList<Integer>(member));
			return;
		}
		// 只从后往前到index搜索，不会搜索index之前的，所以结果不会重复
		back1(ans,index + 1,target,member,candidates);
		target = target - candidates[index];
		if(target >= 0){
			member.add(candidates[index]);
			back1(ans,index,target,member,candidates);
			member.remove(member.size() -1);
		}
	}

	//回溯法
	public List<List<Integer>> solution2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		back2(ans,0,target,new ArrayList<>(),candidates);
		return ans;
	}

	//无剪枝 从前往后去重
	private void back2(List<List<Integer>> ans , int begin , int target , List<Integer> member , int[] candidates){
		if(target == 0){
			ans.add(new ArrayList<>(member));
		}
		if(target < 0){
			return;
		}
		for (int i = begin; i < candidates.length; i++) {
			member.add(candidates[i]);
			back2(ans,i,target - candidates[i],member,candidates);
			member.remove(member.size() - 1);
		}
	}

	//回溯法
	public List<List<Integer>> solution3(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		back3(ans,0,target,new ArrayList<>(),candidates);
		return ans;
	}

	//有剪枝
	private void back3(List<List<Integer>> ans , int begin , int target , List<Integer> member , int[] candidates){
		if(target == 0){
			ans.add(new ArrayList<>(member));
		}
		for (int i = begin; i < candidates.length; i++) {
			if(target -candidates[i] < 0){
				break;
			}
			member.add(candidates[i]);
			back3(ans,i,target -candidates[i],member,candidates);
			member.remove(member.size() - 1);
		}
	}
}
