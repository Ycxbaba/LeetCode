package solution;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class LevelOrder {
	public int[] levelOrder(TreeNode root) {
		if(root == null)return new int[0];
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		ArrayList<Integer> ans = new ArrayList<>();
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				ans.add(poll.val);
				if(poll.left != null){
					queue.offer(poll.left);
				}
				if(poll.right != null){
					queue.offer(poll.right);
				}
			}
		}
		int[] res = new int[ans.size()];
		int index = 0;
		for (Integer an : ans) {
			res[index++] = an;
		}
		return res;
	}
}
