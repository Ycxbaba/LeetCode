package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/exclusive-time-of-functions/
 */
public class ExclusiveTime {
	public int[] exclusiveTime(int n, List<String> logs) {
		Deque<int[]> stack = new ArrayDeque<int[]>(); // {idx, 开始运行的时间}
		int[] res = new int[n];
		for (String log : logs) {
			int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
			String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
			int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
			if ("start".equals(type)) {
				if (!stack.isEmpty()) {
					res[stack.peek()[0]] += timestamp - stack.peek()[1];
					stack.peek()[1] = timestamp;
				}
				stack.push(new int[]{idx, timestamp});
			} else {
				int[] t = stack.pop();
				res[t[0]] += timestamp - t[1] + 1;
				if (!stack.isEmpty()) {
					stack.peek()[1] = timestamp + 1;
				}
			}
		}
		return res;
	}

	public int[] exclusiveTime2(int n, List<String> logs) {
		int[] ans = new int[n];
		Deque<int[]> stack = new ArrayDeque<int[]>();
		for (String log : logs) {
			int index = Integer.parseInt(log.substring(0,log.indexOf(":")));
			String type = log.substring(log.indexOf(":") + 1,log.lastIndexOf(":"));
			int time = Integer.parseInt(log.substring(log.lastIndexOf(":")+1));
			if("start".equals(type)){
				if(!stack.isEmpty()){
					ans[stack.peek()[0]] += time - stack.peek()[1];
					stack.peek()[1] = time;
				}
				stack.push(new int[]{index,time});
			}else {
				ans[index] += time - stack.pop()[1] + 1;
				if(!stack.isEmpty()){
					stack.peek()[1] = time + 1;
				}
			}
		}

		return ans;
	}
}
