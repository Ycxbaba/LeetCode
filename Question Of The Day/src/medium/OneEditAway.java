package medium;

/**
 * https://leetcode.cn/problems/one-away-lcci/
 */
public class OneEditAway {

	public static void main(String[] args) {

	}

	public boolean solution(String first, String second) {
		int len1 = first.length();
		int len2 = second.length();
		//替换
		if(len1 == len2){
			boolean flag = false;
			for (int i = 0; i < len1; i++) {
				if(first.charAt(i) != second.charAt(i)){
					if(!flag){
						flag = true;
					}else{
						return false;
					}
				}
			}
			return true;
		}else if(len1 == len2 -1){
			int index1 = 0, index2 = 0;
			while (index1 < len1 && index2 < len2){
				if(first.charAt(index1) == second.charAt(index2))index1++;
				index2++;
				if(index2 - index1 > 1){
					return false;
				}
			}
			return true;
		}else if (len1 == len2 + 1){
			int index1 = 0, index2 = 0;
			while (index1 < len1 && index2 < len2){
				if(first.charAt(index1) == second.charAt(index2))index2++;
				index1++;
				if(index1 - index2 > 1){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
