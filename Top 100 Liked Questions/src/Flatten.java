import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class Flatten {
	public static void main(String[] args) {

	}

	//递归
	public void solution1(TreeNode root) {
		List<TreeNode>  list = new ArrayList<>();
		preBack(list,root);
		for (int i = 1; i < list.size(); i++) {
			TreeNode cur = list.get(i);
			TreeNode pre = list.get(i-1);
			pre.left = null;
			pre.right = cur;
		}
	}

	public void preBack(List<TreeNode>  list,TreeNode treeNode){
		if(treeNode == null){
			return;
		}
		list.add(treeNode);
		preBack(list,treeNode.left);
		preBack(list,treeNode.right);
	}

	//栈
	public void solution2(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()){
			while (node != null){
				list.add(node);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		int size = list.size();
		for (int i = 1; i < size; i++) {
			TreeNode prev = list.get(i - 1), curr = list.get(i);
			prev.left = null;
			prev.right = curr;
		}
	}

	//同时进行
	public void solution3(TreeNode root) {
		if(root == null)return;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty()){
			TreeNode cur = stack.pop();
			if(prev != null){
				prev.left = null;
				prev.right = cur;
			}
			TreeNode left = cur.left,right = cur.right;
			//先压入 右节点
			if (right != null) {
				stack.push(right);
			}
			if (left != null) {
				stack.push(left);
			}
			prev = cur;
		}
	}

	//空间复杂度为 1
	public void solution4(TreeNode root) {
		TreeNode cur = root;
		while (cur != null){
			if(cur.left != null){
				TreeNode next = cur.left;
				TreeNode pre = next;
				while (pre.right != null){
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.left = null;
				cur.right = next;
			}
			cur = cur.right;
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
