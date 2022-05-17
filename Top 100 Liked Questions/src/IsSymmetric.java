import javax.swing.tree.TreeNode;
import java.util.Base64;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class IsSymmetric {
	public static void main(String[] args) {

	}
	public boolean solution(TreeNode root) {
		if(root == null)return true;
		return check(root.left,root.right);
	}

	private boolean check(TreeNode l, TreeNode r){
		if(r == null && l == null ){
			return true;
		}else if(r != null && l != null && r.val == l.val){
			return check(l.left,r.right) && check(l.right,r.left);
		}else {
			return false;
		}
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
