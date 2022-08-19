package test;

import entity.ListNode;

import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		ListNode h1 = new ListNode(9);
		h1.next = new ListNode(3);
		h1.next.next = new ListNode(7);
		h1.next.next.next = new ListNode(1);
		h1.next.next.next.next = new ListNode(6);
		System.out.println(test.sortInList(h1));
	}

	public ListNode sortInList (ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode fast = head.next.next;
		ListNode mid = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			mid = mid.next;
		}
		slow.next = null;
		return megen(sortInList(head),sortInList(mid));
	}


	private ListNode megen(ListNode h1 ,ListNode h2){
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		while (h1 != null && h2 != null){
			if(h1.val > h2.val){
				temp.next = h2;
				temp = h2;
				h2 = h2.next;
			}else {
				temp.next = h1;
				temp = h1;
				h1 = h1.next;
			}
		}
		if(h1 == null){
			temp.next = h2;
		}else{
			temp.next = h1;
		}

		return dummy.next;
	}

	public boolean isPail (ListNode head) {
		// write code here
		// 1 -> 2 <- 2 <- 1
		// 1 -> 2 -> 1 <- 2 <- 1
		if(head == null || head.next == null)return true;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode cur = slow.next;
		slow.next = null;
		fast = null;
		while (cur != null){
			fast = cur.next;
			cur.next = slow;
			slow = cur;
			cur = fast;
		}
		while (head != null && slow != null){
			if(head.val != slow.val){
				return false;
			}
			head = head.next;
			slow = slow.next;
		}
		return true;
	}

}
