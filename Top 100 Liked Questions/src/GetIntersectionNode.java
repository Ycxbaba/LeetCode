public class GetIntersectionNode {
	public static void main(String[] args) {

	}
	public ListNode solution1(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)return null;
		ListNode a = headA;
		ListNode b = headB;
		int aCount = 0 , bCount = 0;
		while (a != null || b != null){
			if(a != null){
				a = a.next;
				aCount++;
			}
			if(b != null){
				b = b.next;
				bCount ++;
			}
		}
		int c = aCount - bCount;
		if(c > 0){
			for (int i = 0; i < c; i++) {
				headA = headA.next;
			}
		}else {
			for (int i = 0; i < -c; i++) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null){
			if(headA == headB){
				return headA;
			}else {
				headA = headA.next;
				headB = headB.next;
			}
		}
		return null;
	}

	//双指针 ----- 真的秒
	//走过相同的路，才能遇见彼此
	public ListNode solution2(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)return null;
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
