package solution;

/**
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
public class FindNthDigit {
	//01234567891011121314151617181920212223242526272829****99100101102103
	public int findNthDigit(int n) {
		int digit = 1;   // n所在数字的位数
		long start = 1;  // 数字范围开始的第一个数
		long count = 9;  // 占多少位
		while(n > count){
			n -= count;
			digit++;
			start *= 10;
			count = digit * start * 9;
		}
		long num = start + (n - 1) / digit;
		return Long.toString(num).charAt((n - 1) % digit) - '0';
	}

	public static void main(String[] args) {
		FindNthDigit findNthDigit = new FindNthDigit();
		findNthDigit.findNthDigit(10);
	}
}
