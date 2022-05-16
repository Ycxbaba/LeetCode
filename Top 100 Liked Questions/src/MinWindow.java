import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class MinWindow {
	public static void main(String[] args) {

	}

	//滑动窗口 ------ 有优化空间
	Map<Character, Integer> ori = new HashMap<Character, Integer>();
	Map<Character, Integer> cnt = new HashMap<Character, Integer>();

	public String solution(String s, String t) {
		for (char c : t.toCharArray()) {
			ori.put(c,ori.getOrDefault(c,0)+1);
		}
		int l = 0, r = -1;
		int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
		int sLen = s.length();
		while (r < sLen){
			++r;
			if(r < sLen && ori.containsKey(s.charAt(r))){
				cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
			}
			while (check() && r >= l){
				if(r- l + 1 < len){
					len = r - l + 1;
					ansL = l;
					ansR = l + len;
				}
				if(ori.containsKey(s.charAt(l))){
					cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0) - 1);
				}
				l++;
			}
		}
		return ansL == -1 ? "" : s.substring(ansL, ansR);
	}
	public boolean check() {
		for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			if(cnt.getOrDefault(key,0) < value){
				return false;
			}
		}
		return true;
	}

}
