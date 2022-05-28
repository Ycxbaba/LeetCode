package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-closest-lcci/
 */
public class FindClosest {
	public int solution1(String[] words, String word1, String word2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)){
				list1.add(i);
			}
			if(words[i].equals(word2)){
				list2.add(i);
			}
		}
		int ans = Integer.MAX_VALUE;
		for (Integer integer1 : list1) {
			for (Integer integer2 : list2) {
				ans = Math.min(Math.abs(integer1-integer2),ans);
			}
		}
		return ans;
	}

	public int solution2(String[] words, String word1, String word2) {
		int ans = Integer.MAX_VALUE;
		int index1 = - 1, index2 = -1;
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)){
				index1 = i;
			}else if(words[i].equals(word2)) {
				index2 = i;
			}
			if(index1>=0 && index2>= 0){
				ans = Math.min(ans,Math.abs(index1-index2));
			}
		}
		return ans;
	}
}
