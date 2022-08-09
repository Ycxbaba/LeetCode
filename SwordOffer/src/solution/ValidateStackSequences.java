package solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Deque<Integer> stack = new LinkedList<>();
		int i = 0;
		for (int item : pushed) {
			stack.push(item);
			while (!stack.isEmpty() && stack.peek() == popped[i]){
				i++;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
