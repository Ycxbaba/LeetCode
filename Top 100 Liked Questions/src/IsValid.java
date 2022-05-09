
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class IsValid {

	public static void main(String[] args) {
		IsValid isValid = new IsValid();
		boolean solution = isValid.solution("()[]{}");
		System.out.println(solution);
	}

	//栈模拟
	//时间复杂度 n 空间复杂度 n
	public boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '{' || c == '[' || c == '('){
				stack.push(c);
			}else{
				if(stack.isEmpty()){
					return false;
				}
				if(c == ']' && stack.peek() == '['){
					stack.pop();
				}else if(c == '}' && stack.peek() == '{'){
					stack.pop();
				}else if(c == ')' && stack.peek() == '('){
					stack.pop();
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	/*
	  更为简洁巧妙的写法，思路一样
	  public boolean solution1(String s) {
	       Stack<Character>stack = new Stack<Character>();
	          for(char c: s.toCharArray()){
	              if(c=='(')stack.push(')');
	              else if(c=='[')stack.push(']');
	              else if(c=='{')stack.push('}');
	              else if(stack.isEmpty()||c!=stack.pop())return false;
	          }
	          return stack.isEmpty();
	      }
	 */
}
