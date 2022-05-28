package start;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/
 */
public class Combine {

	public static void main(String[] args) {
		Combine combine = new Combine();
		List<List<Integer>> combine1 = combine.combine(4, 2);
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		back(ans,new ArrayList<>(),n,k,1);
		return ans;
	}

	private void back(List<List<Integer>> ans,List<Integer> member,int n,int k,int cur){
		if(member.size() == k){
			ans.add(new ArrayList<>(member));
			return;
		}
		for (int i = cur ; i <= n; i++) {
			//剪枝
			if(member.size() + n - cur + 1 < k){
				break;
			}
			member.add(i);
			back(ans,member,n,k,i+1);
			member.remove(member.size()-1);
		}
	}

	private void back2(List<List<Integer>> ans,List<Integer> member,int n,int k,int cur){
		if(member.size() + n - cur + 1 < k){
			return;
		}
		if(member.size() == k){
			ans.add(new ArrayList<>(member));
			return;
		}
		member.add(cur);
		back2(ans,member,n,k,cur+1);
		member.remove(member.size()-1);

		back2(ans,member,n,k,cur+1);
	}
}
