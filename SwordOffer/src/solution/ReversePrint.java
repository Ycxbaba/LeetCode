package solution;

import bean.ListNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {
	public int[] reversePrint(ListNode head) {
		if(head == null)return new int[]{};
		Stack<Integer> stack = new Stack<>();
		while (head != null){
			stack.push(head.val);
			head = head.next;
		}
		int[] ans = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()){
			ans[i] = stack.pop();
			i++;
		}
		return ans;
	}

	public int[] reversePrint2(ListNode head) {
		if(head == null)return new int[]{};
		int len = 0;
		ListNode h = head;
		while (head != null){
			len++;
			head = head.next;
		}
		int[] ans = new int[len];
		while (h != null){
			ans[len - 1] = h.val;
			len --;
			h = h.next;
		}
		return ans;
	}

}
