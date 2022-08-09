package solution;

/**
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class PrintNumbers {
	public int[] printNumbers(int n) {
		int end = (int) Math.pow(10,n) - 1;
		int[] ans = new int[end];
		for (int i = 0; i < end; i++) {
			ans[i] = i + 1;
		}
		return ans;
	}
}
