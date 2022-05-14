import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class Trap {
	public static void main(String[] args) {
		Trap trap = new Trap();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap.solution3(height));
	}

	//动态编程
	//时间复杂度 n 空间复杂度 n
	public int solution1(int[] height) {
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		int ans = 0;
		right[0]  = height[0];
		for (int i = 1; i < len; i++) {
			right[i] = Math.max(height[i],right[i-1]);
		}
		left[len-1] = height[len-1];
		for (int i = len - 2; i >= 0 ; i--) {
			left[i] = Math.max(height[i],left[i+1]);
		}
		for (int i = 0; i < len; i++) {
			ans += Math.min(left[i],right[i]) - height[i];
		}
		return ans;
	}

	//双指针
	//时间复杂度 n 空间复杂度 1
	public int solution2(int[] height) {
		int len = height.length;
		int ans = 0;
		int left = 0,leftMax = 0;
		int right = len -1,rightMax =0;
		while (left < right){
			if(height[left] > height[right]){
				if(height[right] > rightMax){
					rightMax = height[right];
				}else {
					ans += rightMax - height[right];
				}
				right--;
			}else {
				if(height[left] > leftMax){
					leftMax = height[left];
				}else {
					ans += leftMax - height[left];
				}
				left++;
			}
		}
		return ans;
	}

	//单调栈
	//时间复杂度 n 空间复杂度 n
	public int solution3(int[] height){
		int ans = 0, current = 0;
		Deque<Integer> stack = new LinkedList<Integer>();
		while (current < height.length) {
			while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
				int top = stack.pop();
				if (stack.isEmpty())
					break;
				int distance = current - stack.peek() - 1;
				int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
				ans += distance * bounded_height;
			}
			stack.push(current++);
		}
		return ans;
	}
}
