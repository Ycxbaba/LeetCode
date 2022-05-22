package medium;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/can-i-win/solution/
 */
public class canIWin {
	public boolean solution(int maxChoosableInteger, int desiredTotal) {
		if(maxChoosableInteger * (maxChoosableInteger + 1)/2 < desiredTotal)return false;
		if(maxChoosableInteger >= desiredTotal)return true;
		return dfs(0,0,desiredTotal,maxChoosableInteger,new HashMap<>());
	}

	private boolean dfs(int current, int total, int desiredTotal, int maxChoosableInteger, HashMap<Integer,Boolean> map){
		if (!map.containsKey(current)) {
			boolean res = false;
			for (int i = 0; i < maxChoosableInteger; i++) {
				//0为没有被选到过的
				if ((current >> i & 1) == 0) {
					if(total + i + 1 >= desiredTotal){
						res = true;
						break;
					}else if(!dfs(current | 1 << i,total + 1 + i,desiredTotal,maxChoosableInteger,map)){
						res = true;
						break;
					}
				}
			}
			map.put(current,res);
		}
		return map.get(current);
	}

}
