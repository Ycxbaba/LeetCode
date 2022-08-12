package solution;

/**
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNum {
	//12258
	// 8
	// 5 8
	// 2 5 8 , 25 8
	// 2 2 5 8 , 2 25 8 , 22 5 8
	// 1 2 2 5 8 , 1 25 8 , 1 22 5 8 , 12 2 5 8 , 12 25 8
	public int translateNum(int num) {
		int t1 = 1;
		int t0 = 1;
		int ans = 1;
		int pre = num % 10;
		int cur = 0;
		while (num != 0){
			num /= 10;
			cur = (num) % 10;
			if( cur != 0 && (cur * 10 + pre) <= 25){
				ans = t0 + t1;
				t1 = t0;
				t0 = ans;
			}else {
				t1 = t0;
			}
			pre = cur;
		}
		return ans;
	}

	public static void main(String[] args) {
		TranslateNum translateNum = new TranslateNum();
		translateNum.translateNum(1068385902);
	}
}
