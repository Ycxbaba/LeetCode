import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

	Deque<Integer> minStack;
	Deque<Integer> stack;

	public MinStack() {
		minStack = new LinkedList<>();
		stack = new LinkedList<>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int val) {
		stack.push(val);
		minStack.push(Math.min(minStack.peek(),val));
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}

