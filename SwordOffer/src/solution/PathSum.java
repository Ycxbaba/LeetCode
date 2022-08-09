package solution;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int target) {
		List<List<Integer>> pathSum = new ArrayList<>();
		dfs(pathSum,new ArrayList<>(),root,target);
		return pathSum;
	}

	private void dfs(List<List<Integer>> pathSum,List<Integer> member,TreeNode node,int target) {
		if(node == null)return;
		member.add(node.val);
		target -= node.val;
		if(target == 0 && node.left == null && node.right == null)pathSum.add(new ArrayList<>(member));
		dfs(pathSum,member,node.left,target);
		dfs(pathSum,member,node.right,target);
		member.remove(member.size() - 1);
	}
}
