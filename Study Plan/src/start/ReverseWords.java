package start;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWords {
	public static void main(String[] args) {

	}
	public String reverseWords(String s) {
		StringBuilder ans = new StringBuilder();
		int index = 0;
		int pre = 0;
		while (index < s.length()){
			if(s.charAt(index) == ' '){
				for (int i = index - 1; i >= pre; i--) {
					ans.append(s.charAt(i));
				}
				ans.append(' ');
				pre = index + 1;
			}
			index ++;
		}
		for (int i = s.length()-1; i >= pre; i--) {
			ans.append(s.charAt(i));
		}
		return ans.toString();
	}
}
