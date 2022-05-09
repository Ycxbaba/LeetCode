/**
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumbers {

	public static void main(String[] args) {

	}

	public ListNode solution(ListNode l1, ListNode l2) {
		ListNode head = null,next = null;
		int c = 0,v1 = 0, v2 =0,val = 0;
		while (l1 != null || l2 != null){
			v1 = l1 != null ? l1.val : 0;
			v2 = l2 != null ? l2.val : 0;
			val = (v1 + v2 + c) % 10;
			c = (v1 + v2 + c) / 10;
			if(head == null){
				head = next = new ListNode(val);
			}else {
				next.next = new ListNode(val);
				next = next.next;
			}
			if(l1 != null){
				l1 = l1.next;
			}
			if(l2 != null){
				l2 = l2.next;
			}
		}
		//不要忘记进位
		if(c > 0){
			next.next = new ListNode(c);
		}
		return head;
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
