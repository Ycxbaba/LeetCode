package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/string-matching-in-an-array/
 */
public class StringMatching {
	public List<String> stringMatching(String[] words) {
		List<String> ans = new ArrayList<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (words[j].contains(words[i])) {
					ans.add(words[i]);
					break;
				}
			}
		}
		return ans;

	}
}
