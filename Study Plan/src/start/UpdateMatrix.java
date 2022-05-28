package start;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/01-matrix/
 */
public class UpdateMatrix {

	//BFS ----- 对于由一个点出发 ， 寻找到这个点的最短路径用广度优先搜索
	public int[][] solution1(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] ans = new int[m][n];
		boolean[][] seen = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(mat[i][j]==0){
					queue.offer(new int[]{i,j});
					seen[i][j] = true;
				}
			}
		}
		int[][] dict = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
		while (!queue.isEmpty()){
			int[] poll = queue.poll();
			for (int[] ints : dict) {
				int i = ints[0] + poll[0];
				int j = ints[1] + poll[1];
				if(i>=0 && j>= 0 && i<m && j<n && !seen[i][j]){
					ans[i][j] = ans[poll[0]][poll[1]] + 1;
					seen[i][j] = true;
					queue.offer(new int[]{i,j});
				}
			}
		}
		return ans;
	}

	//动态规划
	public int[][] solution2(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] ans = new int[m][n];
		for (int i = 0; i < m; ++i) {
			// 防止 + 1 溢出
			Arrays.fill(ans[i], Integer.MAX_VALUE / 2);
		}
		//0 的 位置距离时0
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 0) {
					ans[i][j] = 0;
				}
			}
		}

		//左上移动
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i - 1 >= 0){
					ans[i][j] = Math.min(ans[i][j],ans[i-1][j]+1);
				}
				if(j - 1 >= 0){
					ans[i][j] = Math.min(ans[i][j],ans[i][j-1]+1);
				}
			}

		}
		// 右下移动
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if(i + 1 < m){
					ans[i][j] = Math.min(ans[i][j],ans[i+1][j]+1);
				}
				if(j + 1 < n){
					ans[i][j] = Math.min(ans[i][j],ans[i][j+1]+1);
				}
			}

		}

		//不用找右上和左下的原因
		return ans;
	}

}
