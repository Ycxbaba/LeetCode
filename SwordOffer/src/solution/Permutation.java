package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Permutation {
	public String[] permutation(String s) {
		int length = s.length();
		char[] chars = s.toCharArray();
		Set<String> ans = new HashSet<>();
		boolean[] flag = new boolean[length];
		dfs("",chars,length, ans,flag);
		return ans.toArray(new String[0]);
	}

	private void dfs(String s, char[] chars, int length, Set<String> ans, boolean[] flag) {
		if(s.length() == length){
			ans.add(s);
			return;
		}
		for (int i = 0; i < length; i++) {
			if(flag[i])continue;
			flag[i] = true;
			dfs(s + chars[i],chars,length,ans,flag);
			flag[i] = false;
		}
	}

	List<String> list = new ArrayList<>();
	char[] tar;

	public String[] permutation2(String s) {
		int length = s.length();
		tar = s.toCharArray();
		dfs(0);
		return list.toArray(new String[0]);
	}

	private void dfs(int index) {
		if(index == tar.length - 1){
			list.add(String.valueOf(tar));
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = index; i < tar.length; i++) {
			if(set.contains(tar[i]))continue;
			set.add(tar[i]);
			swap(i,index);
			dfs(index + 1);
			swap(i,index);
		}
	}

	private void swap(int i,int j){
		char temp = tar[i];
		tar[i] = tar[j];
		tar[j] = temp;
	}
}
