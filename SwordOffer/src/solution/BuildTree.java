package solution;

import bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 */
public class BuildTree {
	public static void main(String[] args) {
		int[] preorder = new int[]{3, 9, 20, 15, 7}, inorder = new int[]{9, 3, 15, 20, 7};
		BuildTree buildTree = new BuildTree();
		buildTree.buildTree(preorder, inorder);
	}

	private Map<Integer, Integer> indexMap;

	public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right, int inorder_left) {
		if (preorder_left > preorder_right) {
			return null;
		}

		// 前序遍历中的第一个节点就是根节点
		// 在中序遍历中定位根节点
		int inorder_root = indexMap.get(preorder[preorder_left]);

		// 先把根节点建立出来
		TreeNode root = new TreeNode(preorder[preorder_left]);
		// 得到左子树中的节点数目
		int size_left_subtree = inorder_root - inorder_left;
		// 递归地构造左子树，并连接到根节点
		// 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
		root.left = myBuildTree(preorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left);
		// 递归地构造右子树，并连接到根节点
		// 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
		root.right = myBuildTree(preorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1);
		return root;
	}

	public TreeNode buildTreeNormal(int[] preorder, int[] inorder) {
		int n = preorder.length;
		// 构造哈希映射，帮助我们快速定位根节点
		indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		return myBuildTree(preorder, 0, n - 1, 0);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		if(n== 0)return null;
		indexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			indexMap.put(inorder[i],i);
		}
		return build(preorder,0,n-1,0);
	}

	private TreeNode build(int[] preorder,int pLeft,int pRight,int iLeft) {
		if(pLeft > pRight){
			return null;
		}
		int iRoot = indexMap.get(preorder[pLeft]);
		TreeNode root = new TreeNode(preorder[pLeft]);
		int len = iRoot - iLeft;
		root.left = build(preorder,pLeft + 1, pLeft + len,iLeft);
		root.right = build(preorder,pLeft+len+1,pRight,iRoot + 1);
		return root;
	}

}
