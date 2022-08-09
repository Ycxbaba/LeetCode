package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

	Deque<Integer> stackIn;
	Deque<Integer> stackOut;

	public CQueue() {
		stackIn = new ArrayDeque<>();
		stackOut = new ArrayDeque<>();
	}

	public void appendTail(int value) {
		stackIn.push(value);
	}

	public int deleteHead() {
		if(stackOut.isEmpty()){
			if(stackIn.isEmpty()){
				return -1;
			}
			while (!stackIn.isEmpty()){
				stackOut.push(stackIn.pop());
			}
		}
		return stackOut.pop();
	}
}
