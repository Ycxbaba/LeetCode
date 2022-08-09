package solution;

/**
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class SpiralOrder {
	public int[] spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int p = 0;
		int q = 0;
		int[] ans = new int[m * n];
		int status = 0;
		int index = 0;
		while (index < ans.length){
			status %= 4;
			if(status == 0){
				for (int j = q; j < n; j++) {
					ans[index++] = matrix[p][j];
				}
				p++;
			}else if (status == 1){
				for (int j = p; j < m; j++) {
					ans[index++] = matrix[j][n - 1];
				}
				n--;
			}else if (status == 2){
				for (int j = n - 1; j >= q; j--) {
					ans[index++] = matrix[m - 1][j];
				}
				m--;
			}else if (status == 3){
				for (int j = m - 1; j >= p; j--) {
					ans[index++] = matrix[j][q];
				}
				q++;
			}
			status ++;
		}
		return ans;
	}
}
