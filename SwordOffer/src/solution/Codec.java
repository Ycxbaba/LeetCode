package solution;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Codec {
	/**
	 * 爽啊，自己独立做出一道困难题目
	 * @param root
	 * @return
	 */
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null){
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		sb.append(root.val).append(",");
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if(poll.left != null){
					queue.offer(poll.left);
					sb.append(poll.left.val).append(",");
				}else {
					sb.append("null").append(",");
				}

				if(poll.right != null){
					queue.offer(poll.right);
					sb.append(poll.right.val).append(",");
				}else {
					sb.append("null").append(",");
				}
			}
		}
		int pre = sb.length();
		while (sb.substring(pre-5,pre).equals("null,")){
			pre = pre - 5;
		}
		String substring = sb.substring(0, pre - 1);
		return substring + "]";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String substring = data.substring(1, data.length() - 1);
		if(substring.length() == 0)return null;
		String[] tree = substring.split(",");
		int len = tree.length;
		TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int i = 1;
		while (i < len){
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				TreeNode poll = queue.poll();
				if(i < len && !"null".equals(tree[i++])){
					poll.left = new TreeNode(Integer.parseInt(tree[i-1]));
					queue.offer(poll.left);
				}
				if(i < len && !"null".equals(tree[i++])){
					poll.right = new TreeNode(Integer.parseInt(tree[i-1]));
					queue.offer(poll.right);
				}
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		TreeNode treeNode = codec.deserialize("[1,2]");
		System.out.println(codec.serialize(treeNode));

	}
}
