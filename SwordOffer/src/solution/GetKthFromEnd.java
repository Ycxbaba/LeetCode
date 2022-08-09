package solution;

import bean.ListNode;

/**
 *  https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class GetKthFromEnd {
	public ListNode getKthFromEnd(ListNode head, int k) {
		if(head == null)return null;
		ListNode slow = head;
		ListNode fast = head;
		while (k > 0){
			fast = fast.next;
			k--;
		}
		if(fast == null)return head.next;
		while (fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow.next;
	}
}
