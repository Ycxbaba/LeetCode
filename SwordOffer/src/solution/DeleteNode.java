package solution;

import bean.ListNode;

public class DeleteNode {
	public ListNode deleteNode(ListNode head, int val) {
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode nex = pre;
		while (head != null){
			if(head.val == val){
				pre.next = head.next;
				break;
			}
			pre = head;
			head = head.next;
		}
		return nex.next;
	}
}
