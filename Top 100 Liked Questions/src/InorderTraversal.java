import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
	public static void main(String[] args) {

	}

	//递归
	public List<Integer> solution1(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		mid(ans,root);
		return ans;
	}

	private void mid(List<Integer> ans,TreeNode root){
		if(root == null){
			return;
		}
		mid(ans,root.left);
		ans.add(root.val);
		mid(ans,root.right);
	}

	//栈 其实就是 递归的显示表达
	public List<Integer> solution2(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		while (root != null || !deque.isEmpty()){
			while (root != null){
				deque.push(root);
				root = root.left;
			}
			root = deque.pop();
			ans.add(root.val);
			root = root.right;
		}
		return ans;
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

	//Morris算法
	public List<Integer> solution3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode predecessor = null;

		while (root != null) {
			if (root.left != null) {
				// predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
				predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root) {
					predecessor = predecessor.right;
				}

				// 让 predecessor 的右指针指向 root，继续遍历左子树
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				}
				// 说明左子树已经访问完了，我们需要断开链接
				else {
					res.add(root.val);
					predecessor.right = null;
					root = root.right;
				}
			}
			// 如果没有左孩子，则直接访问右孩子
			else {
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}

}
