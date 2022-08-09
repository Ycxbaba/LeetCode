package solution;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class MirrorTree {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode res = root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				TreeNode temp = poll.left;
				poll.left = poll.right;
				poll.right = temp;
				if(poll.right != null){
					queue.offer(poll.right);
				}
				if(poll.left != null){
					queue.offer(poll.left);
				}
			}
		}
		return res;
	}
}
