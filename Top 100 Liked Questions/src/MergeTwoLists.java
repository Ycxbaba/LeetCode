/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

	public static void main(String[] args) {

	}

	//迭代
	//时间复杂度 2*min(m,n) 空间复杂度 1
	public ListNode solution1(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(-1);
		ListNode prev = ans;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
		prev.next = l1 == null ? l2 : l1;

		return ans.next;

	}

	//递归
	//时间复杂度 m+n  空间复杂度 m+n 消耗栈空间
	public ListNode solution2(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}else if(l1.val >= l2.val){
			l2.next = solution2(l1,l2.next);
			return l2;
		}else {
			l1.next = solution2(l1.next,l2);
			return l1;
		}
	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
