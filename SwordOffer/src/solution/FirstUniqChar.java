package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {
	//best
	public char firstUniqChar(String s) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) -'a'] ++;
		}
		for (int i = 0; i < s.length(); i++) {
			if(count[s.charAt(i) - 'a'] == 1)return s.charAt(i);
		}
		return ' ';
	}

	public char firstUniqChar2(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c,i);
				queue.offer(c);
			}else {
				map.put(c,-1);
				while (!queue.isEmpty() && map.get(queue.peek()) == -1){
					queue.poll();
				}
			}
		}
		return queue.isEmpty() ? ' ' : queue.peek();
	}
}
