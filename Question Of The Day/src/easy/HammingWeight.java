package easy;

/**
 * https://leetcode.cn/problems/number-of-1-bits/submissions/
 */
public class HammingWeight {
	public int solution1(int n) {
		int ans = 0;
		for(int i = 0; i<32;i++){
			if(((n >> i) & 1) == 1)ans++;
		}
		return ans;
	}
	//优化
	public int solution2(int n) {
		int ans = 0;
		while (n!=0){
			//去掉最低为的1
			n = n & (n-1);
			ans++;
		}
		return ans;
	}

	//源码
	//下面的博文使用数学解释，很不错
	//https://blog.csdn.net/zhouzipeng000/article/details/56676885?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.pc_relevant_default&utm_relevant_index=1
	public int solution3(int n) {
		//  0x55555555      01010101 01010101 01010101 01010101
		//  0x33333333      00110011 00110011 00110011 00110011
		//  0x0f0f0f0f      00001111 00001111 00001111 00001111
		//  0x3f            00000000 00000000 00000000 00111111

		//最初每一位代表一位上有多少个1
		n = n - ((n >>> 1) & 0x55555555);  //等同于 (n & 0x55555555) + ((n >>> 1) & 0x55555555)
		//经过上面 1 次运算后，此时用 2 位数代表每 2 位有几个 1，如 00_01_01_11 可以用00_01_01_10 来表示了
		n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
		//经过上面 2 次运算后，此时用 4 位数代表每 4 位有几个 1，如 0001_0111 可以用 0001_0011 来表示了
		n = (n + (n >>> 4)) & 0x0f0f0f0f;   //等同于 (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f)
		//经过上面 3 次运算后，此时用 8 位数代表每 8 位有几个 1，如 00010111 可以用 00000100 来表示了
		//此时 已经将 32 位的数 每 8 位 统计一下 1 的个数 记为 C1_C2_C3_C4,下面就要合并统计了

		//我们将每 16 位的前8位 和 后8位 相加 此时记为 C1+C2_C3+C4
		n = n + (n >>> 8);
		//我们将 32 位的前16位 和 后16位 相加 此时记为 C1+C2+C3+C4
		n = n + (n >>> 16);
		//我们只需取 后 6 位，因为 32位的整数 最多有 32 个 1  0b'0010_0000
		return n & 0x3f;
	}
}
