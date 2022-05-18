import java.util.*;

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wordBreak = new WordBreak();
		String s = "leetcodec";
		List<String> dict = new ArrayList<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak.solution(s, dict));
	}

	public boolean solution(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if(dp[j] && set.contains(s.substring(j,i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
