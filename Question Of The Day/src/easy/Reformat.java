package easy;

/**
 * https://leetcode.cn/problems/reformat-the-string/
 */
public class Reformat {
	public String reformat(String s) {
		int len = s.length();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				sb1.append(c);
			}else {
				sb2.append(c);
			}
		}
		StringBuilder ans = new StringBuilder();
		if(sb1.length() == sb2.length()){
			for (int i = 0; i < sb1.length(); i++) {
				ans.append(sb1.charAt(i));
				ans.append(sb2.charAt(i));
			}
		}else if(sb1.length() - sb2.length() == 1){
			for (int i = 0; i < sb2.length(); i++) {
				ans.append(sb1.charAt(i));
				ans.append(sb2.charAt(i));
			}
			ans.append(sb1.charAt(sb1.length() -1));
		}else if( sb2.length() - sb1.length() == 1){
			for (int i = 0; i < sb1.length(); i++) {
				ans.append(sb2.charAt(i));
				ans.append(sb1.charAt(i));
			}
			ans.append(sb2.charAt(sb2.length() -1));
		}
		return ans.toString();
	}
}
