package start;

import javax.swing.tree.TreeNode;

/**
 * https://leetcode.cn/problems/merge-two-binary-trees/
 */
public class MergeTrees {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return pre(root1,root2);
	}

	private TreeNode pre(TreeNode n1,TreeNode n2){
		if(n1 == null){
			return n2;
		}
		if(n2 == null){
			return n1;
		}

		TreeNode treeNode = new TreeNode(n1.val + n2.val);

		treeNode.left = pre(n1.left,n2.left);
		treeNode.right = pre(n1.right,n2.right);

		return treeNode;
	}

	private static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode() {}
		public TreeNode(int val) { this.val = val; }
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
