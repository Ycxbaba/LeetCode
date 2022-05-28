package start;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

	public static void main(String[] args) {
		String s = "a1b2";
		LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
		List<String> list = letterCasePermutation.solution1(s);
	}

	public List<String> solution1(String s) {
		char[] chars = s.toCharArray();
		List<String> ans = new ArrayList<>();
		dfs(ans,new StringBuffer(),chars,0);
		return ans;
	}

	private void dfs(List<String> ans,StringBuffer stringBuffer,char[] chars,int cur){
		if(stringBuffer.length() == chars.length){
			ans.add(stringBuffer.toString());
			return;
		}
		char c = chars[cur];
		stringBuffer.append(c);
		if(c >= 97 && c <= 123){
			dfs(ans,stringBuffer,chars,cur+1);
			stringBuffer.setCharAt(stringBuffer.length()-1,(char) (c - 32));
			dfs(ans,stringBuffer,chars,cur+1);
		}else if(c >= 65 && c <= 91){
			dfs(ans,stringBuffer,chars,cur+1);
			stringBuffer.setCharAt(stringBuffer.length()-1,(char) (c + 32));
			dfs(ans,stringBuffer,chars,cur+1);
		}else {
			dfs(ans,stringBuffer,chars,cur+1);
		}
		stringBuffer.deleteCharAt(stringBuffer.length() - 1);
	}


	public List<String> solution2(String s) {
		char[] chars = s.toCharArray();
		List<String> ans = new ArrayList<>();
		dfs2(ans,chars,0);
		return ans;
	}
	private void dfs2(List<String> ans,char[] chars,int cur){
		if(cur == chars.length){
			ans.add(new String(chars));
			return;
		}
		dfs2(ans,chars,cur+1);
		if(Character.isLetter(chars[cur])){
			chars[cur] ^= 1 << 5;
			dfs2(ans,chars,cur + 1);
		}
	}
}
