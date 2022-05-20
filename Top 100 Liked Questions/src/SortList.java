/**
 *
 */
public class SortList {
	public static void main(String[] args) {
		int[] nums = {-1,5,3,4,0};
		ListNode head = new ListNode();
		ListNode cur  = head;
		for (int i = 0; i < nums.length; i++) {
			cur.val = nums[i];
			if(i != nums.length - 1){
				cur.next = new ListNode();
				cur = cur.next;
			}
		}
		SortList sortList = new SortList();
		sortList.sortList(head);
	}
	//他奶奶的 超时
	public ListNode solution1(ListNode head) {
		ListNode cur = head;
		while (cur != null){
			ListNode next = cur.next;
			while (next != null){
				if( cur.val > next.val){
					int temp = cur.val;
					cur.val = next.val;
					next.val = temp;
				}
				next = next.next;
			}
			cur = cur.next;
		}
		return head;
	}
	public ListNode sortList(ListNode head) {
		return sort(head,null);
	}
	//自上而下
	//拆分
	private ListNode sort(ListNode start,ListNode end){
		if(start == end)return start;
		ListNode fast = start,slow = start;
		while (fast != end && fast.next != end){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode l1 = sort(slow.next, end);
		slow.next = null;
		ListNode l2 = sort(start, slow);

		return merge(l1,l2);

	}
	//递归写法
	private ListNode merge(ListNode l1,ListNode l2){
		if(l1 == null || l2 == null){
			return l1 == null ? l2 : l1;
		}
		if(l1.val > l2.val){
			l2.next = merge(l1,l2.next);
			return l2;
		}else{
			l1.next = merge(l1.next,l2);
			return l1;
		}
	}
	//迭代写法
	private ListNode merge2(ListNode l1,ListNode l2){
		ListNode head = new ListNode();
		ListNode temp = head , temp1 = l1,temp2 = l2;
		while (temp1 != null && temp2 != null){
			if(temp1.val > temp2.val){
				temp.next = temp2;
				temp2 = temp2.next;
			}else {
				temp.next = temp1;
				temp1 = temp1.next;
			}
			temp = temp.next;
		}
		if(temp1 != null){
			temp.next = temp1;
		}else if(temp2 != null) {
			temp.next = temp2;
		}
		return head.next;
	}


	//自下而上
	private ListNode sort2(ListNode head){
		if(head == null)return head;
		//统计链表长度
		int size = 0;
		ListNode count = head;
		while (count != null){
			size++;
			count = count.next;
		}
		ListNode ahead = new ListNode();
		ahead.next = head;
		for (int subLen = 1; subLen < size; subLen <<= 1) {
			ListNode pre = ahead;
			ListNode cur = ahead.next;
			while (cur != null){
				ListNode head1 = cur;
				for (int i = 1; i < subLen && cur.next != null; i++) {
					cur = cur.next;
				}
				ListNode head2 = cur.next;
				cur.next = null;
				cur = head2;
				for (int i = 1; i < subLen && cur != null && cur.next !=null; i++) {
					cur = cur.next;
				}
				ListNode next = null;
				if(cur != null){
					next = cur.next;
					cur.next = null;
				}
				pre.next = merge2(head1, head2);
				while (pre.next != null){
					pre = pre.next;
				}
				cur = next;
			}
		}
		return ahead.next;
	}




	private static class ListNode {
		int val;
		ListNode next;
		ListNode(){};
		ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
