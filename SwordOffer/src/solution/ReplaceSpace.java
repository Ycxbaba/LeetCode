package solution;

import java.util.StringJoiner;

/**
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {
	//LeetCode无法使用StringJoiner
	public String replaceSpace(String s) {
		String[] strings = s.split(" ");
		StringJoiner sj = new StringJoiner("%20");
		for (String string : strings) {
			sj.add(string);
		}
		return sj.toString();
	}
	//会出现空格连续的情况
	public String replaceSpace2(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ')sb.append("%20");
			else sb.append(c);
		}
		return sb.toString();
	}

	public String replaceSpace3(String s) {
		return s.replace(" ","%20");
	}

	//双指针 java不好，string不可变，不存在 O(1)的空间复杂度
	public String replaceSpace4(String s){
		return s;
	}

	public static void main(String[] args) {
		ReplaceSpace replaceSpace = new ReplaceSpace();
		System.out.println(replaceSpace.replaceSpace("we are super man."));
	}
}
