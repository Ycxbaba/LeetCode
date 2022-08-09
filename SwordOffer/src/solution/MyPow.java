package solution;

/**
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class MyPow {
	public double myPow(double x, int n) {
		long N = n;
		double ans = 1.0;
		if(n < 0){
			x = 1 / x;
			N = -N;
		}
		while ( N > 0){
			if((N & 1) == 1){
				ans = ans * x;
			}
			x *= x;
			N >>= 1;
		}
		return ans;
	}

}
