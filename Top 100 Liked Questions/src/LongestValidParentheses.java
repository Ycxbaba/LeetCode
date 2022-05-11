import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses parentheses = new LongestValidParentheses();
		int i = parentheses.solution3(")()())");
		System.out.println(i);
	}
	//栈
	//时间复杂度 n  空间复杂度 n
	public int solution1(String s) {
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '('){
				stack.push(i);
			}else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				}else {
					ans = Math.max(ans,i - stack.peek());
				}
			}
		}
		return ans;
	}

	//动态规划
	//时间复杂度 n  空间复杂度 n
	public int solution2(String s) {
		int max = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == ')'){
				//考虑 () 的情况，之前的有效字串长度加上2
				if(s.charAt(i-1) == '('){
					dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
				//考虑 )) 的情况，..之前的有效字串.. ? ..有效字串..) ?的位置是否为 (
					//如果是, 有效字串 + 之前的的有效字串长度 + 2
				}else if(i-1-dp[i-1] >= 0 && s.charAt(i-1-dp[i-1]) == '('){
					dp[i] = dp[i-1] + (i-2-dp[i-1] >= 0 ? dp[i-2-dp[i-1]] : 0) + 2;
				}
				max = Math.max(max,dp[i]);
			}
			//不考虑 ( ,因为以 ( 结尾的不可能是有效字串
		}
		return max;
	}

	//双指针
	//时间复杂度 n  空间复杂度 1
	public int solution3(String s) {
		//只能统计）多于（情况
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
		}
		////补充统计（多于）情况
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left > right) {
				left = right = 0;
			}
		}
		return maxlength;
	}
}
