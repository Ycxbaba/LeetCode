import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
	public static void main(String[] args) {

	}

	//深度优先搜索
	public int solution1(char[][] grid) {
		int ans = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1'){
					ans++;
					dfs(grid,i,j);
				}
			}
		}
		return ans;
	}
	private void dfs(char[][] grid,int i , int j){
		if(grid[i][j] != '1')return;
		grid[i][j] = '0';
		int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
		for (int[] ints : direct) {
			int newI = i + ints[0];
			int newJ = j + ints[1];
			if(newI < grid.length && newI >= 0 && newJ < grid[0].length && newJ >= 0){
				dfs(grid,newI,newJ);
			}
		}
	}

	//广度优先搜索 -- 仅仅作为练习
	public int solution2(char[][] grid) {
		if(grid == null || grid.length == 0)return 0;
		int ans = 0;
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(grid[i][j] == '1'){
					ans++;
					grid[i][j] = '0';
					Queue<Integer> queue = new LinkedList<>();
					queue.offer(i*col + j);
					while (!queue.isEmpty()){
						Integer poll = queue.poll();
						int r = poll / col;
						int c = poll % col;
						if(r + 1 < row && grid[r+1][c] == '1'){
							queue.offer((r+1)*col + c);
							grid[r+1][c] = '0';
						}
						if(r - 1 >= 0 && grid[r-1][c] == '1'){
							queue.offer((r-1)*col + c);
							grid[r-1][c] = '0';
						}
						if(c + 1 < col && grid[r][c+1] == '1'){
							queue.offer(r*col + c+1);
							grid[r][c+1] = '0';
						}
						if(c - 1 >= 0 && grid[r][c-1] == '1'){
							queue.offer(r*col + c-1);
							grid[r][c-1] = '0';
						}
					}
				}
			}
		}
		return ans;
	}

	//并查集 ----- 值得研究
	public int solution3(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int nr = grid.length;
		int nc = grid[0].length;
		int num_islands = 0;
		UnionFind uf = new UnionFind(grid);
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					grid[r][c] = '0';
					if (r - 1 >= 0 && grid[r-1][c] == '1') {
						uf.union(r * nc + c, (r-1) * nc + c);
					}
					if (r + 1 < nr && grid[r+1][c] == '1') {
						uf.union(r * nc + c, (r+1) * nc + c);
					}
					if (c - 1 >= 0 && grid[r][c-1] == '1') {
						uf.union(r * nc + c, r * nc + c - 1);
					}
					if (c + 1 < nc && grid[r][c+1] == '1') {
						uf.union(r * nc + c, r * nc + c + 1);
					}
				}
			}
		}

		return uf.getCount();
	}
	private static class UnionFind {
		int count;
		int[] parent;
		int[] rank;

		public UnionFind(char[][] grid) {
			count = 0;
			int m = grid.length;
			int n = grid[0].length;
			parent = new int[m * n];
			rank = new int[m * n];
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (grid[i][j] == '1') {
						parent[i * n + j] = i * n + j;
						++count;
					}
					rank[i * n + j] = 0;
				}
			}
		}

		public int find(int i) {
			if (parent[i] != i) parent[i] = find(parent[i]);
			return parent[i];
		}

		public void union(int x, int y) {
			int rootx = find(x);
			int rooty = find(y);
			if (rootx != rooty) {
				if (rank[rootx] > rank[rooty]) {
					parent[rooty] = rootx;
				} else if (rank[rootx] < rank[rooty]) {
					parent[rootx] = rooty;
				} else {
					parent[rooty] = rootx;
					rank[rootx] += 1;
				}
				--count;
			}
		}

		public int getCount() {
			return count;
		}
	}

}
