package solution;

import bean.Node;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class TreeToDoublyList {
	Node pre,head;
	public Node treeToDoublyList(Node root) {
		if(root == null)return null;
		mid(root);
		head.left = pre;
		pre.right = head;
		return head;
	}

	public void mid(Node root){
		if(root == null)return;
		mid(root.left);
		if(pre == null)head = root;
		else pre.right = root;
		root.left = pre;
		pre = root;
		mid(root.right);
	}

	/**
	 * 面试题 单链表 空间复杂度 o(1)
	 */
	public Node treeToList(Node root) {
		if(root == null)return null;
		Node t = root;
		while (root.right != null){
			while (root.right.left != null){
				rotateRight(root,root.right);
			}
			root = root.right;
		}
		root = t;
		while (root.left != null){
			while (root.left.right != null){
				rotateLeft(root,root.left);
			}
			root = root.left;
		}

		//反转左子树
		root = t;
		Node left;
		while (root.left != null){
			left = root.left;
			root.left.right = root;
			root.left = null;
			root = left;
		}
		return root;
	}

	private void rotateRight(Node pre,Node cur){
		Node right = cur;
		cur = cur.left;
		right.left = cur.right;
		cur.right = right;
		pre.right = cur;
	}
	private void rotateLeft(Node pre,Node cur){
		Node left = cur;
		cur = cur.right;
		left.right = cur.left;
		cur.left = left;
		pre.left = cur;
	}

	public static void main(String[] args) {
		TreeToDoublyList treeToDoublyList = new TreeToDoublyList();
		Node node = new Node(8);
		node.left = new Node(4);
		node.right = new Node(12);
		node.left.left = new Node(2);
		node.left.right = new Node(6);
		node.right.left = new Node(10);
		node.right.right = new Node(14);
		treeToDoublyList.treeToList(node);
	}
}
