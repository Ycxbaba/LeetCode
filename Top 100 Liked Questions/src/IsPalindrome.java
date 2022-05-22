import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
public class IsPalindrome {
	public static void main(String[] args) {

	}

	public boolean isPalindrome(ListNode head) {
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null){
			ListNode temp = slow.next;
			if(pre != null){
				slow.next = pre;
			}
			pre = slow;
			fast = fast.next.next;
			slow = temp;
		}

		if(fast != null)slow = slow.next;
		while (slow != null){
			if(pre.val != slow.val)return false;
			pre = pre.next;
			slow = slow.next;
		}
		return true;
	}


	private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
