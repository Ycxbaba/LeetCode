import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {

	}

	/**
	 *  滑动窗口
	 *  使用快慢两个指针,慢指针用来遍历,快指针用于找最长字串
	 *  时间复杂度 n
	 *  空间复杂度 所有出现的字符个数
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
