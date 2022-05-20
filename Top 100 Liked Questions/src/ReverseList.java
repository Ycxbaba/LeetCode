/**
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseList {
	public static void main(String[] args) {

	}

	public ListNode reverseList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
