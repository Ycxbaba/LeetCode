import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree {
	public static void main(String[] args) {

	}

	//递归
	private HashMap<Integer,Integer> map = new HashMap<>();

	public TreeNode solution1(int[] preorder, int[] inorder) {
		int len = inorder.length;
		for (int i = 0; i < len; i++) {
			map.put(inorder[i],i );
		}
		return build(preorder,inorder,0,len-1,0,len-1);
	}

	private TreeNode build(int[] preorder,int[] inorder,int preorder_left,int preorder_right,
	                       int inorder_left,int inorder_right){
		if(preorder_left > preorder_right){
			return null;
		}
		int inorder_root = map.get(preorder[preorder_left]);
		TreeNode root = new TreeNode(preorder[preorder_left]);
		int left_size = inorder_root - inorder_left;
		root.left = build(preorder,inorder,
				preorder_left + 1,preorder_left + left_size,
				inorder_left,inorder_root-1);
		root.right = build(preorder,inorder,
				preorder_left + left_size + 1,preorder_right,
				inorder_root + 1,inorder_right);
		return root;
	}

	//迭代 ----- 值得思考
	private TreeNode solution2(int[] preorder, int[] inorder){
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		int inorderIndex = 0;
		for (int i = 1; i < preorder.length; i++) {
			int preorderVal = preorder[i];
			TreeNode node = stack.peek();
			if (node.val != inorder[inorderIndex]) {
				node.left = new TreeNode(preorderVal);
				stack.push(node.left);
			} else {
				while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
					node = stack.pop();
					inorderIndex++;
				}
				node.right = new TreeNode(preorderVal);
				stack.push(node.right);
			}
		}
		return root;
	}

	/*
	 //迭代 ---- 练习
	 private TreeNode solution2_self(int[] preorder, int[] inorder){
	 	if(preorder == null || preorder.length == 0)return null;
	 	Deque<TreeNode> stack = new LinkedList<>();
	 	TreeNode root = new TreeNode(preorder[0]);
	 	stack.push(root);
	 	int orderIndex = 0;
	 	for (int i = 1; i < preorder.length; i++) {
	 		int preVal = preorder[i];
	 		TreeNode peek = stack.peek();
	 		if(peek.val != inorder[orderIndex]){
	 			peek.left = new TreeNode(preVal);
	 			stack.push(peek.left);
	 		}else {
	 			while (!stack.isEmpty() && stack.peek().val == inorder[orderIndex]){
	 				peek = stack.pop();
	 				orderIndex ++;
	 			}
	 			peek.right = new TreeNode(preVal);
	 			stack.push(peek.right);
	 		}
	 	}
	 	return root;
	 }
	 */


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
