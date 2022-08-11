package solution;

import bean.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class CopyRandomList {

	Map<Node,Node> map = new HashMap<>();

	public Node copyRandomList(Node head) {
		if(head == null)return null;
		if(!map.containsKey(head)){
			Node newHead = new Node(head.val);
			map.put(head,newHead);
			newHead.next = copyRandomList(head.next);
			newHead.random = copyRandomList(head.random);
		}
		return map.get(head);
	}


	public Node copyRandomList2(Node head) {
		if(head == null)return null;
		Node temp = head;
		// 1 - 2 - 3
		// 1 - 1 -2 -2 -3 -3
		while (head != null){
			Node node = new Node(head.val);
			node.next = head.next;
			head.next = node;
			head = node.next;
		}

		head = temp;
		// 处理random，在此之前所有节点都创建好了
		while (head != null){
			Node node = head.next;
			if(head.random != null)node.random = head.random.next;
			head = node.next;
		}

		head = temp;
		Node ans = head.next;
		while (head != null){
			Node node = head.next;
			head.next = node.next;
			if(node.next != null)node.next = node.next.next;
			head = head.next;
		}
		return ans;
	}
}
