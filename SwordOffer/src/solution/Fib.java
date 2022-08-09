package solution;

public class Fib {
	public int fib(int n) {
		int mod = 1000000007;
		if(n < 2)return n;
		int first = 0,second = 1;
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			ans = (first + second) % mod;
			first = second;
			second = ans;
		}
		return ans;
	}
	//矩阵快速幂
	public int fib1(int n) {
		if(n < 2) return 2;
		int[][] m = new int[][]{{1,1},{1,0}};
		int[][] res = pow(m,n-1);
		return res[0][0];
	}

	private int[][] pow(int[][] m, int n) {
		int[][] res = new int[][]{{1,0},{0,1}};
		while (n > 0){
			if((n & 1) == 1){
				res = multiply(res,m);
			}
			m = multiply(m,m);
			n >>= 1;
		}
		return res;
	}

	private int[][] multiply(int[][] m, int[][] n) {
		int[][] res = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				res[i][j] = (int) (((long)m[i][0] * n[0][j] + (long) m[i][1] * n[1][j]) % 1000000007);
			}
		}
		return res;
	}


}
