package solution;

/**
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class HammingWeight {
	public int hammingWeight(int n) {
		int ans = 0;
		while ( n != 0){
			n = n & (n - 1);
			ans ++;
		}
		return ans;
	}
}
