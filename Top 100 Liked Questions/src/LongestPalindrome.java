/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		System.out.println(longestPalindrome.solution1("cbbd"));
	}

	//动态规划
	//时间复杂度 n*n  空间复杂度 n*n
	public String solution1(String s) {
		int n = s.length();
		int max = 1;
		int begin = 0;
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		for (int len = 2; len <= n ; len++) {
			for (int i = 0; i < n; i++) {
				int j = i + len -1;

				if(j >= n){
					break;
				}

				if(s.charAt(i) != s.charAt(j)){
					dp[i][j] = false;
				}else {
					if(j-i < 3){
						dp[i][j] = true;
					}else {
						dp[i][j] = dp[i+1][j-1];
					}
				}

				if(dp[i][j] && j-i+1>max){
					max =j-i+1;
					begin = i;
				}
			}
		}
		return s.substring(begin,begin+max);
	}

	//中心扩散
	//时间复杂度 n*n 空间复杂度 1
	public String solution2(String s){
		int max = 1;
		int begin = 0;
		for (int i = 0; i < s.length(); i++) {
			//考虑奇数回文
			int len1 = centerExtend(s,i,i);
			//考虑偶数回文
			int len2 = centerExtend(s,i,i+1);
			int len = Math.max(len1,len2);
			if(len > max){
				max = len;
				begin = i - (len-1)/2;
			}
		}
		return s.substring(begin,begin+max);
	}
	//从点向两边扩散
	public int centerExtend(String s,int left,int right){
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			++right;
			--left;
		}
		// 退出循环时长度扩大了两格需要减去 right - left + 1 - 2
		return right - left - 1;
	}

}
