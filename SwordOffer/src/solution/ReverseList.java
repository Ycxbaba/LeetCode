package solution;

import bean.ListNode;

/**
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode next;
		ListNode pre = null;
		while (cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
