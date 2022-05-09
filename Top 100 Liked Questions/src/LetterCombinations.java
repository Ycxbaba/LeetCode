import java.util.*;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

	public static void main(String[] args) {

	}

	//回溯算法
	//时间复杂度 3^m * 4^n  空间复杂度 3^m * 4^n
	public List<String> solution(String digits) {
		List<String> ans = new ArrayList<>();
		if(digits.length() == 0){
			return ans;
		}
		HashMap<Character, String> map = new HashMap<>();
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4',"ghi");
		map.put('5',"jkl");
		map.put('6',"mno");
		map.put('7',"pqrs");
		map.put('8',"tuv");
		map.put('9',"wxyz");
		back(ans,map,digits,0,new StringBuffer());
		return ans;
	}

	public void back(List<String> ans,HashMap<Character, String> map,String s,int index,StringBuffer stringBuffer){
		if(index == s.length()){
			ans.add(stringBuffer.toString());
		}else {
			char c = s.charAt(index);
			String s1 = map.get(c);
			for (int i = 0; i < s1.length(); i++) {
				stringBuffer.append(s1.charAt(i));
				back(ans,map,s,index + 1,stringBuffer);
				//删掉当前的最后一位，避免回溯 有残余字符
				stringBuffer.deleteCharAt(index);
			}
		}

	}
}
