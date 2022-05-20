/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class DetectCycle {
	public static void main(String[] args) {

	}
	// slow = x + n * cycle + z
	// fast = x + (n + 1) * cycle + z
	// 2x + 2z = x + cycle + z
	// x = cycle - z
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null){
			if(fast.next != null){
				fast = fast.next.next;
				slow = slow.next;
			}else {
				return null;
			}
			if(fast == slow){
				ListNode cur = head;
				while (cur != slow){
					cur = cur.next;
					slow = slow.next;
				}
				return cur;
			}

		}
		return null;
	}
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
