package solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class VerifyPostorder {
	public boolean verifyPostorder(int[] postorder) {
		return recur(postorder, 0, postorder.length - 1);
	}
	boolean recur(int[] postorder, int i, int j) {
		if(i >= j) return true;
		int p = i;
		while(postorder[p] < postorder[j]) p++;
		int m = p;
		while(postorder[p] > postorder[j]) p++;
		return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
	}

	public boolean verifyPostorder2(int[] postorder) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MAX_VALUE;
		for (int i = postorder.length - 1; i >=0; i--) {
			if(postorder[i]>root)return false;
			while (!stack.isEmpty() && postorder[i] < stack.peek())root = stack.pop();
			stack.push(postorder[i]);
		}
		return true;
	}

}
