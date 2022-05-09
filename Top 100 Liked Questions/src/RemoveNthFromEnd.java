/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

	public static void main(String[] args) {

	}

	//双指针
	//时间复杂度 n 空间复杂度 1
	public ListNode solution(ListNode head, int n) {
		//没有这个节点导致如果要删除的节点在第一位，会很麻烦
		ListNode temp = new ListNode(0,head);
		ListNode left = temp;
		ListNode right = head;

		for (int i = 0; i < n; i++) {
			right = right.next;
		}

		while (right !=null){
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return temp.next;
	}

	/**
	 *  不用额外的节点
	 * 	public ListNode solution(ListNode head, int n) {
	 * 		ListNode slow = head;
	 * 		ListNode fast = head;
	 *
	 * 		while(n > 0){
	 * 			n--;
	 * 			fast = fast.next;
	 *                }
	 * 		if(fast == null){
	 * 			return head.next;
	 *        }
	 * 		while(fast.next != null){
	 * 			slow = slow.next;
	 * 			fast = fast.next;
	 *        }
	 * 		fast = slow.next;
	 * 		slow.next = fast.next;
	 *
	 * 		return head;*
	 * 	}
	 */
    private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
