/**
 * https://leetcode.cn/problems/rotate-image/
 */
public class Rotate {
	public static void main(String[] args) {

	}

	//把图像分割为四块 顺时针旋转
	//时间复杂度 n*n/4 空间复杂度 1
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len / 2; i++) {
			for (int j = 0; j < (len + 1) / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len-j-1][i];
				matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
				matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
				matrix[j][len-i-1] = temp;
			}
		}
	}
}
