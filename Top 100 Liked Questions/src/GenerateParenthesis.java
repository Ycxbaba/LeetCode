import java.util.*;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class GenerateParenthesis {

	public static void main(String[] args) {

	}

	//递归
	public List<String> solution1(int n) {
		List<String> ans = new ArrayList<>();
		temp(n,ans,new StringBuffer(),n,0);
		return ans;
	}

	private void temp(int n1,List<String> ans,StringBuffer stringBuffer,int n2,int index){
		if(n1 == 0 && n2 == 0){
			ans.add(stringBuffer.toString());
			return;
		}
		if(n1 == n2){
			stringBuffer.append('(');
			temp(n1-1,ans,stringBuffer,n2,index+1);
			stringBuffer.deleteCharAt(index);
		}else if(n1 < n2){
			if(n1 > 0){
				stringBuffer.append('(');
				temp(n1-1,ans,stringBuffer,n2,index+1);
				stringBuffer.deleteCharAt(index);
			}
			stringBuffer.append(')');
			temp(n1,ans,stringBuffer,n2-1,index+1);
			stringBuffer.deleteCharAt(index);
		}
	}

	//模拟插空
	//思路可以学习，但对于这道题而言，有更优解，不推荐
	// _1_ '(' _2_ ')' _3_ 向 1 2 3 位置插空 使用set去重
	public static List<String> solution2(int n){
		if (n == 1){
			return Collections.singletonList("()");
		}
		HashSet<String> set = new HashSet<>();
		for (String str : solution2(n - 1)){
			for (int i = 0; i <= str.length()/2; i++) {
				set.add(str.substring(0,i) + "()" + str.substring(i,str.length()));
			}
		}
		return new ArrayList<>(set);
	}
}
