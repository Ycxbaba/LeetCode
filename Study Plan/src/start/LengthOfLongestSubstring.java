package start;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
	public int solution(String s) {
		Set<Character> set = new HashSet<>();
		int ans = 0,left = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(i != 0)set.remove(s.charAt(i-1));
			while (left + 1 < s.length() && !set.contains(s.charAt(left + 1))){
				left++;
				set.add(s.charAt(left));
			}
			ans = Math.max(ans,left - i + 1);
		}
		return ans;
	}
}
