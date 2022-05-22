/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */
public class SearchMatrix {
	public static void main(String[] args) {
		SearchMatrix searchMatrix = new SearchMatrix();
		int[][] matrix = {{1,3,5}};
		int target = 1;
		System.out.println(searchMatrix.searchMatrix(matrix, target));
	}

	//Z行搜索
	//从右上角开始搜索，从右上角看是一颗搜索二叉树
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int x = 0, y = n - 1;
		while (x < m && y >= 0) {
			if (matrix[x][y] == target) {
				return true;
			}else if (matrix[x][y] > target) {
				--y;
			} else {
				++x;
			}
		}
		return false;
	}
}
