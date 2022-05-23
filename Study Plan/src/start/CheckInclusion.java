package start;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/permutation-in-string/
 */
public class CheckInclusion {
	public boolean solution1(String s1, String s2) {
		if(s1.length() > s2.length())return false;
		int len1 = s1.length();
		int len2 = s2.length();
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < len1; i++) {
			char c = s1.charAt(i);
			map.put(c,map.getOrDefault(c,0) + 1);
		}
		for (int i = 0; i <= len2 - len1; i++) {
			int index = i;
			while (index < len2 && map.containsKey(s2.charAt(index))){
				Integer integer = map.get(s2.charAt(index));
				integer --;
				if(integer == 0){
					map.remove(s2.charAt(index));
				}else {
					map.put(s2.charAt(index),integer);
				}
				index ++ ;
			}
			//找到了
			if(map.size() == 0)return true;
			while (index >= i){
				map.put(s2.charAt(index),map.getOrDefault(s2.charAt(index),0)+1);
				index--;
			}
		}
		return false;
	}

	public boolean solution2(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int[] count = new int[26];
		for (char c : str1) {
			count[c - 'a'] ++;
		}
		int l = 0,r=0;
		while (l <= len2 - len1){
			while (r < l + len1 && count[s2.charAt(r) - 'a'] > 0){
				count[s2.charAt(r) - 'a'] --;
				r++;
			}
			if(r - l == len1)return true;
			count[s2.charAt(l) - 'a']++;
			l++;
		}
		return false;
	}
}
