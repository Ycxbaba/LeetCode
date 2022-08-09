package solution;

public class CuttingRope2 {
	public int cuttingRope(int n) {
		if(n <= 3)return n-1;
		if(n == 4)return 4;
		int i = n / 3;
		int j = n % 3;
		int ans = 0;
		if(j == 0)return fast(i) % 1000000007;
		else if(j == 1)return (int) ((long)fast(i-1) * 4 % 1000000007);
		else return (int)((long)fast(i) * 2 % 1000000007);
	}

	private int fast(int i) {
		int n = 3;
		int ans = 1;
		while ( i > 0){
			if((i & 1) == 1){
				ans = (int)((long) ans * n % 1000000007);
			}
			n = (int) ((long) n * n % 1000000007);
			i >>= 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		CuttingRope2 cuttingRope2 = new CuttingRope2();
		cuttingRope2.cuttingRope(100);
	}
}
