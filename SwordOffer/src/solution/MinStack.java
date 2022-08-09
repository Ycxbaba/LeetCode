package solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack {

	private final Deque<Integer> stack;
	private final Deque<Integer> minStack;


	public MinStack() {
		stack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		stack.push(x);
		minStack.push(Math.min(minStack.peek(),x));
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return minStack.peek();
	}
}
