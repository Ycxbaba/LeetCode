import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class IsValidBST {
	public static void main(String[] args) {

	}
	public boolean solution1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode pre = null;
		while (root != null){
			if(root.left != null){
				pre = root.left;
				while (pre.right != null && pre.right != root){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = root;
					root = root.left;
				}else {
					pre.right = null;
					list.add(root.val);
					root = root.right;
				}
			}else {
				list.add(root.val);
				root = root.right;
			}
		}
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i) <= list.get(i-1)){
				return false;
			}
		}
		return true;
	}

	//morris 优化
	public boolean solution2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode pre = null;
		while (root != null){
			if(root.left != null){
				pre = root.left;
				while (pre.right != null && pre.right != root){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = root;
					root = root.left;
				}else {
					pre.right = null;
					if (list.size() > 0 && list.get(list.size() - 1) >= root.val ) {
						return false;
					}
					list.add(root.val);
					root = root.right;
				}
			}else {
				if (list.size() > 0 && list.get(list.size() - 1) >= root.val) {
					return false;
				}
				list.add(root.val);
				root = root.right;
			}
		}
		return true;
	}

	//递归
	public boolean solution3(TreeNode root) {

		return back(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	private boolean back(TreeNode cur,long min,long max){
		if(cur == null){
			return true;
		}
		if(cur.val >= max || cur.val <= min){
			return false;
		}
		return back(cur.left,min,cur.val) && back(cur.right,cur.val,max);
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
