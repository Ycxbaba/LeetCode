package solution;

public class NumWays {
	public int numWays(int n) {
		if(n == 0)return 1;
		if(n < 2)return n;
		int ans = 0;
		int p = 0,q = 1;
		for (int i = 0; i < n; i++) {
			ans = (p + q)%1000000007;
			p = q;
			q = ans;
		}
		return ans;
	}

	//矩阵快速幂
	public int numWays2(int n) {
		if(n == 0)return 1;
		if(n < 2)return n;
		int[][] m = new int[][]{{1,1},{1,0}};
		int[][] ans = pow(m,n-1);
		return ans[0][0];
	}

	private int[][] pow(int[][] m, int n) {
		int[][] res = new int[][]{{1,0},{0,1}};
		while (n > 0){
			if ((n&1) == 1)res = multiply(res,m);
			n>>=1;
			m = multiply(m,m);
		}
		return res;
	}

	private int[][] multiply(int[][] m, int[][] n) {
		int[][] ans = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				ans[i][j] = (int)((((long) m[i][0] * n[0][j]) + ((long) m[i][1] * n[1][j]))%1000000007);
			}
		}
		return ans;
	}
}
