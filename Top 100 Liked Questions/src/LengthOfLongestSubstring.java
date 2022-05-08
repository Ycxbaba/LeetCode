import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	/**
	 *  滑动窗口
	 *  使用快慢两个指针,慢指针用来遍历,快指针用于找最长字串
	 */
	public int solution(String s) {
		Set<Character> set = new HashSet<>();
		int n = s.length();
		int ans = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if(i != 0){
				set.remove(s.charAt(i-1));
			}
			while (j < n && !set.contains(s.charAt(j))){
				set.add(s.charAt(j));
				j++;
			}
			ans = Math.max(j - i, ans);
		}
		return ans;
	}
}
