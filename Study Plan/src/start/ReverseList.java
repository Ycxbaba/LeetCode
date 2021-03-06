package start;

import java.util.List;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		while (head != null){
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
