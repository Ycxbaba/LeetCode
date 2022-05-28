package start;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/rotting-oranges/
 */
public class OrangesRotting {
	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int ans = -1;
		int count1 = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//初始化 烂橘子入队
				if(grid[i][j] == 2){
					queue.offer(new int[]{i,j});
				}
				//好橘子 计数
				if(grid[i][j] == 1){
					count1++;
				}
			}
		}
		//好橘子 为 0，不需要感染，直接返回
		if(count1 == 0)return 0;

		//烂橘子 不为空，好橘子 不为 0，开始感染
		int[][] dict = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
		while (!queue.isEmpty()){
			int size = queue.size();
			//一轮一轮的感染
			for (int k = 0; k < size; k++) {
				int[] poll = queue.poll();
				int i = poll[0];
				int j = poll[1];
				for (int[] ints : dict) {
					int ni = i + ints[0];
					int nj = j + ints[1];
					if(ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1 ){
						grid[ni][nj] = 2;
						queue.offer(new int[]{ni,nj});
					}
				}
			}
			//轮数计数
			ans++;
		}
		//还有不可能感染的好橘子，-1
		for (int[] ints : grid) {
			for (int j = 0; j < n; j++) {
				if (ints[j] == 1) {
					return -1;
				}
			}
		}
		return ans;
	}
}
