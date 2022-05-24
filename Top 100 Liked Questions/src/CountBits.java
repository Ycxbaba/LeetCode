/**
 * https://leetcode.cn/problems/counting-bits/
 */
public class CountBits {
	//动态规划
	//最高有效位
	public int[] solution1(int n) {
		int[] bits = new int[n + 1];
		int highBit = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				highBit = i;
			}
			bits[i] = bits[i - highBit] + 1;
		}
		return bits;
	}

	//动态规划
	//最低有效位
	public int[] solution2(int n) {
		int[] bits = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			bits[i] = bits[i >> 1] + (i & 1);
		}
		return bits;
	}

	//动态规划
	//最低设置位
	public int[] solution3(int n) {
		int[] bits = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			bits[i] = bits[i & (i - 1)] + 1;
		}
		return bits;
	}
}
