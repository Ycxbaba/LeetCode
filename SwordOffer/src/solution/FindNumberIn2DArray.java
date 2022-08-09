package solution;

/**
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class FindNumberIn2DArray {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0)return false;
		int n = 0;
		int m = matrix[0].length - 1;
		while (n <= matrix.length - 1 && m >= 0){
			if(matrix[n][m] > target){
				m --;
			}else if(matrix[n][m] < target){
				n ++;
			}else {
				return true;
			}
		}
		return false;
	}
}
