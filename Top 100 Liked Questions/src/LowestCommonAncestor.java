import java.util.Stack;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
	public static void main(String[] args) {

	}
	//dfs
	public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)return null;
		if(root == p || root == q)return root;
		dfs(root,p,q);
		return ans;
	}

	TreeNode ans = null;

	private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
		if (root == null || ans != null) return false;
		boolean lson = dfs(root.left, p, q);
		boolean rson = dfs(root.right, p, q);
		if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
			ans = root;
		}
		return lson || rson || (root.val == p.val || root.val == q.val);

	}

	//hash
	//将所有父子关系储存在Map集合中.
	//在目标节点中的任意一个结点出发，向上找父节点，并用Set记录寻找过的父节点.
	//再从另外一个目标节点，出发向上寻找父节点，如果发现该父节点已经找到过，返回该节点
	//空间复杂度和时间复杂度高，不推荐

	private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
