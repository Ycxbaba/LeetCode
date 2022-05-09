/**
 * https://leetcode.cn/problems/regular-expression-matching/
 */
public class IsMatch {

	public static void main(String[] args) {
		IsMatch isMatch = new IsMatch();
		String s = "baaaaaacb";
		String p = "ba*cb";
		boolean solution = isMatch.solution(s, p);
		System.out.println(solution);
	}

	//动态规划
	//时间复杂度 m*n 空间复杂度 m*n
	public boolean solution(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		//从零开始是为了能够使得空字符串匹配 [.*]
		for (int i = 0; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(p.charAt(j-1) == '*'){

					dp[i][j] = dp[i][j-2];
					if(match(s,p,i,j-1)){
						dp[i][j] = dp[i][j] | dp[i-1][j];
					}
				}else {
					if(match(s,p,i,j)){
						dp[i][j]= dp[i-1][j-1];
					}

				}
			}
		}
		return dp[m][n];
	}

	public boolean match(String s,String p,int i, int j){
		if(i == 0){
			return false;
		}

		if(p.charAt(j-1) == '.'){
			return true;
		}

		return s.charAt(i-1) == p.charAt(j-1);
	}
}
