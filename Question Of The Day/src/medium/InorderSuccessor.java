package medium;

/**
 * https://leetcode.cn/problems/successor-lcci/
 */
public class InorderSuccessor {
	public static void main(String[] args) {

	}

	public TreeNode solution(TreeNode root, TreeNode p) {
		if(root == null){
			return null;
		}
		if(root.val <= p.val)return solution(root.right,p);
		TreeNode ans = solution(root.left,p);
		return ans == null ? root : ans;
	}


	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
