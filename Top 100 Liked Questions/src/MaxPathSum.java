import javax.swing.tree.TreeNode;

public class MaxPathSum {
	public static void main(String[] args) {

	}

	int max = Integer.MIN_VALUE;
	public int solution(TreeNode root) {
		maxGain(root);
		return max;
	}

	private int maxGain(TreeNode root) {
		if(root == null){
			return 0;
		}
		int leftSum = Math.max(maxGain(root.left),0);
		int rightSum = Math.max(maxGain(root.right),0);
		int path = leftSum + rightSum + root.val;
		max = Math.max(max,path);
		return root.val + Math.max(leftSum,rightSum);
	}

	public static class TreeNode {
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
