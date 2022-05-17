package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 */
public class IsAlienSorted {
	public static void main(String[] args) {
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		IsAlienSorted isAlienSorted = new IsAlienSorted();
		System.out.println(isAlienSorted.solution1(words, order));
	}

	//使用hash比较慢
	public boolean solution1(String[] words, String order) {
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i),i);
		}
		for (int i = 1; i < words.length; i++) {
			int len1 = words[i-1].length();
			int len2 = words[i].length();
			int j = 0;
			boolean flag = false;
			while (j < Math.min(len1,len2)){
				int pre = map.get(words[i-1].charAt(j));
				int pos = map.get(words[i].charAt(j));
				if (pre == pos) {
					j++;
				}else if(pre > pos){
					return false;
				}else {
					flag = true;
					break;
				}
			}
			if(len1 > len2 && !flag){
				return false;
			}
		}
		return true;
	}

	//使用数组会快一些
	public boolean solution2(String[] words, String order) {
		int[] index = new int[26];
		for (int i = 0; i < order.length(); ++i) {
			index[order.charAt(i) - 'a'] = i;
		}
		for (int i = 1; i < words.length; i++) {
			boolean valid = false;
			for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
				int prev = index[words[i - 1].charAt(j) - 'a'];
				int curr = index[words[i].charAt(j) - 'a'];
				if (prev < curr) {
					valid = true;
					break;
				} else if (prev > curr) {
					return false;
				}
			}
			if (!valid) {
				/* 比较两个字符串的长度 */
				if (words[i - 1].length() > words[i].length()) {
					return false;
				}
			}
		}
		return true;
	}
}
