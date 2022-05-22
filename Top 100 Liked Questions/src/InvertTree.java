import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class InvertTree {
	public static void main(String[] args) {

	}

	//递归写法
	public TreeNode solution1(TreeNode root) {
		reserve(root);
		return root;
	}

	private void reserve(TreeNode node){
		if(node == null)return;
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		reserve(node.left);
		reserve(node.right);
	}

	//非递归写法
	// DFS 优解
	public TreeNode solution2(TreeNode root) {
		if(root == null)return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()){
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				TreeNode pop = stack.pop();
				if(pop.left != null){
					stack.push(pop.left);
				}
				if(pop.right != null){
					stack.push(pop.right);
				}
				TreeNode temp = pop.left;
				pop.left = pop.right;
				pop.right = temp;
			}
		}
		return root;
	}

	//非递归写法
	// BFS
	public TreeNode solution3(TreeNode root) {
		if(root == null)return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			TreeNode poll = queue.poll();
			TreeNode temp = poll.left;
			poll.left = poll.right;
			poll.right = temp;
			if (poll.left != null) {
				queue.offer(poll.left);
			}
			if (poll.right != null) {
				queue.offer(poll.right);
			}
		}
		return root;
	}

	private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
	 }
}
