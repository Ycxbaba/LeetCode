package easy;

/**
 * https://leetcode.cn/problems/di-string-match/
 */
public class DiStringMatch {

	public static void main(String[] args) {

	}
	//时间复杂度 n 空间复杂度 1
	public int[] solution1(String s) {
		int n = s.length();
		int m = 0;
		int[] ans = new int[s.length()+1];
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'I'){
				ans[i] = m;
				m++;
			}else {
				ans[i] = n;
				n--;
			}
		}
		if(s.charAt(s.length()-1) == 'D'){
			ans[s.length()] = m;
		}else {
			ans[s.length()] = n;
		}
		return ans;
	}

	//贪心算法
	//
	public int[] solution2(String s) {
		int len = s.length();
		int[] ans = new int[len+1];
		int min = 0;
		int max = len;
		for (int i = 0; i < len; i++) {
			ans[i] = s.charAt(i) == 'I' ? min++ : max--;
		}
		ans[len] = max;
		return ans;
	}
}
