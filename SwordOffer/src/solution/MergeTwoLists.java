package solution;

import bean.ListNode;

/**
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode pre = head;
		while (l1 != null || l2 != null){
			if(l1 == null){
				head.next = l2;
				break;
			}
			if(l2 == null){
				head.next = l1;
				break;
			}
			if(l1.val > l2.val){
				head.next = new ListNode(l2.val);
				l2 = l2.next;
			}else {
				head.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			head = head.next;
		}
		return pre.next;
	}
}
