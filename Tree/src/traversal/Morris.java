package traversal;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Morris 利用树的大量空指针 来遍历二叉数的一种算法 时间复杂度为 n 空间复杂度为 1
 * 必传统的 递归 和 栈 相比 节约了空间
 *
 * 当 root.left == null 时，root = root.right
 *      如果 root.left != null，找到 root 左子树上最右的节点
 *      如果 root.left == null，可以分为两种情况，一种是叶子节点添加 right 指针的情况，一种是去除叶子节点 right 指针的情况
 *          如果 predecessor 的 right 指针指向空，让其指向 root，root向左移动,即 root = root.left
 *          如果 predecessor 的 right 指针指向 root，让其指向空，root 向右移动，root = root.right
 */
public class Morris {

	private void preorder(TreeNode root){
		TreeNode predecessor = null;
		while (root != null){
			if(root.left != null){
				predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root){
					predecessor = predecessor.right;
				}
				if(predecessor.right == null){
					System.out.println(root.val);
					predecessor.right = root;
					root = root.left;
				}else {
					//第二次到达
					predecessor.right = null;
					root = root.right;
				}
			}else {
				System.out.println(root.val);
				root = root.right;
			}
		}
	}
	private void inorder(TreeNode root){
		TreeNode predecessor = null;
		while (root != null){
			if(root.left != null){
				predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root){
					predecessor = predecessor.right;
				}
				if(predecessor.right == null){
					predecessor.right = root;
					root = root.left;
				}else {
					System.out.println(root.val);
					predecessor.right = null;
					root = root.right;
				}
			}else {
				System.out.println(root.val);
				root = root.right;
			}
		}
	}

	//后续遍历只是输出麻烦了一些
	//右节点需要在中间节点前输出 ，并且 predecessor 指向的是中间节点，那么把 右节点 和 中间节点 反转一下输出就行了，输出完要再次反转恢复
	private void postorder(TreeNode root){
		TreeNode predecessor = null;
		TreeNode cur = root;
		while(cur != null){
			if(cur.left!=null){
				predecessor = cur.left;
				while(predecessor.right!=null && predecessor.right!=cur){
					predecessor = predecessor.right;
				}
				if(predecessor.right==null){
					predecessor.right = cur;
					cur = cur.left;
				}
				else{
					predecessor.right = null;
					postMorris(cur.left);
					cur = cur.right;
				}
			}
			else{
				cur = cur.right;
			}
		}
		postMorris(root);
	}

	public void postMorris(TreeNode root) {
		//反转链表
		TreeNode reverseNode = reverseList(root);
		//遍历链表
		TreeNode cur = reverseNode;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.right;
		}
		//反转回来
		reverseList(reverseNode);
	}

	//反转链表
	public TreeNode reverseList(TreeNode head) {
		TreeNode cur = head;
		TreeNode pre = null;
		while (cur != null) {
			TreeNode next = cur.right;
			cur.right = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
