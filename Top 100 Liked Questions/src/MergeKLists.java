import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

	public static void main(String[] args) {

	}

	//分治
	//将K个边表两两合并后，再次两两合并
	public ListNode solution1(ListNode[] lists) {
		return merge(lists,0,lists.length-1);
	}

	private ListNode merge(ListNode[] list,int n,int m){
		if(n == m){
			return list[n];
		}
		if(n > m){
			return null;
		}
		int mid = (m+n)>>1;
		return mergeTwoList(merge(list,n,mid),merge(list,mid+1,m));
	}

	private ListNode mergeTwoList(ListNode l1,ListNode l2){
		if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}else if(l2.val > l1.val){
			l1.next = mergeTwoList(l1.next,l2);
			return l1;
		}else {
			l2.next = mergeTwoList(l1,l2.next);
			return l2;
		}

	}

	//优先
	//先将每个节点的第一位拿出来放入队列比较，用res指向值最小的节点，移除队列中的最小节点，替换为下一位节点；再次比较，直到队列没有值为止
	public ListNode solution2(ListNode[] lists) {
		if(lists.length == 0){
			return null;
		}

		ListNode ans = new ListNode();
		ListNode temp = ans;

		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		for (ListNode node : lists) {
			if(node == null){
				continue;
			}
			pq.add(node);
		}

		while (!pq.isEmpty()){
			ListNode node = pq.poll();
			temp.next = node;
			temp = temp.next;
			if(node.next != null){
				pq.add(node.next);
			}
		}

		return ans.next;
	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
