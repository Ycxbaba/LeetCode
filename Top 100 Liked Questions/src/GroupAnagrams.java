import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/
 */
public class GroupAnagrams {
	public static void main(String[] args) {

	}

	//排序
	public List<List<String>> solution1(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		for(String str : strs){
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			List<String> list = map.getOrDefault(key, new ArrayList<>());
			list.add(str);
			map.put(key,list);
		}
		return new ArrayList<>(map.values());
	}

	//统计
	public List<List<String>> solution2(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			int[] counts = new int[26];
			int length = str.length();
			for (int i = 0; i < length; i++) {
				counts[str.charAt(i) - 'a']++;
			}
			// 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 26; i++) {
				if (counts[i] != 0) {
					sb.append((char) ('a' + i));
					sb.append(counts[i]);
				}
			}
			String key = sb.toString();
			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(str);
			map.put(key, list);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
