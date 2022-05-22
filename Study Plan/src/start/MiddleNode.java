package start;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class MiddleNode {
	public static void main(String[] args) {

	}
	public ListNode middleNode(ListNode head) {
		if(head == null)return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
