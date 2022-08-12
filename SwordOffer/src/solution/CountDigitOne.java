package solution;

/**
 * https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 */
public class CountDigitOne {
	public int countDigitOne(int n) {
		int high = n;
		int low = 0;
		int cur = 0;

		int ans = 0;
		int temp = 1;
		while (high != 0 || cur != 0){
			cur = high % 10;
			high = high / 10;
			if(cur == 0)ans += high * temp;
			else if(cur == 1)ans += high * temp + low + 1;
			else if(cur > 1)ans += high * temp + temp;

			low = cur * temp + low;
			temp = temp * 10;
		}
		return ans;
	}
}
