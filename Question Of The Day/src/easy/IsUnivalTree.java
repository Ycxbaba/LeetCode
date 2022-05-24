package easy;


import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/univalued-binary-tree/
 */
public class IsUnivalTree {
	//广度优先
	public boolean solution1(TreeNode root) {
		if(root == null)return false;
		Queue<TreeNode> queue = new LinkedList<>();
		int val = root.val;
		queue.offer(root);
		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node.left != null){
				if(node.left.val != val){
					return false;
				}
				queue.offer(node.left);
			}
			if(node.right != null){
				if(node.right.val != val){
					return false;
				}
				queue.offer(node.right);
			}
		}
		return true;
	}

	//深度优先
	public boolean solution2(TreeNode root) {
		if(root == null)return false;
		Stack<TreeNode> stack = new Stack<>();
		int val = root.val;
		stack.push(root);
		while (!stack.isEmpty()){
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = stack.pop();
				if(node.right != null){
					if(node.right.val != val){
						return false;
					}
					stack.push(node.right);
				}
				if(node.left != null){
					if(node.left.val != val){
						return false;
					}
					stack.push(node.left);
				}
			}

		}
		return true;
	}

}
