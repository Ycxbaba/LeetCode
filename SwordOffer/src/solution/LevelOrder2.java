package solution;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder2 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null)return new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				list.add(poll.val);
				if(poll.left != null){
					queue.offer(poll.left);
				}
				if(poll.right != null){
					queue.offer(poll.right);
				}
			}
			ans.add(list);
		}
		return ans;
	}
}