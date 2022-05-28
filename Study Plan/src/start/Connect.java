package start;

import java.util.LinkedList;
import java.util.Queue;

/**
 *https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */
public class Connect {

	//方式1 层序遍历
	public Node solution1(Node root) {
		if(root == null)return null;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			Node poll = null;
			for (int i = 0; i < size; i++) {
				poll = queue.poll();
				if(poll.left != null){
					queue.offer(poll.left);
				}
				if(poll.right != null){
					queue.offer(poll.right);
				}
				if(i < size - 1) {
					poll.next = queue.peek();
				}
			}
		}
		return root;
	}

	public Node solution2(Node root) {
		if(root == null)return null;
		Node preHead = root;
		while (preHead.left != null){
			Node head = preHead;
			while (head != null){
				//连接该节点的子节点
				head.left.next = head.right;
				//连接相邻节点的右节点和左节点
				if(head.next != null){
					head.right.next = head.next.left;
				}
				//下一个相邻节点
				head = head.next;
			}
			//下一层
			preHead = preHead.left;
		}
		return root;
	}


	private static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
}
