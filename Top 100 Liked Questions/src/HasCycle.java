import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class HasCycle {
	public static void main(String[] args) {

	}

	//hash
	public boolean solution1(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while (head != null){
			if(set.contains(head)){
				return true;
			}else {
				set.add(head);
				head = head.next;
			}

		}
		return false;
	}

	//快慢指针
	public boolean solution2(ListNode head) {
		if(head == null || head.next == null)return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast){
			if(fast == null || fast.next == null){
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	//奇技淫巧 ---- 图一乐
	public boolean solution3(ListNode head) {
		while (head != null){
			if (head.val == Integer.MAX_VALUE) {
				return true;
			}else {
				head.val = Integer.MAX_VALUE;
				head = head.next;
			}
		}
		return false;
	}

	private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
	}
}
