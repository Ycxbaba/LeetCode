package easy;

/**
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class RemoveOuterParentheses {
	public String solution(String s) {
		StringBuilder ans = new StringBuilder();
		int left = 0 , right = 0;
		int count = 0;
		while (right < s.length()){
			if(s.charAt(right) == '(')count++;
			else count--;
			if(count == 0){
				ans.append(s, left + 1, right);
				left = right + 1;
			}
			right++;
		}
		return ans.toString();
	}

	public String solution2(String s) {
		int level = 0;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ')') {
				level--;
			}
			if (level > 0) {
				res.append(c);
			}
			if (c == '(') {
				level++;
			}
		}
		return res.toString();
	}
}
