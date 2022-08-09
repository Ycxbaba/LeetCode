package solution;

/**
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Exist {
	public boolean exist(char[][] board, String word) {
		boolean[][] booleans = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == word.charAt(0)){
					if (dfs(word,board,0,booleans,i,j)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean dfs(String word, char[][] board, int index, boolean[][] booleans,int m,int n) {
		if(word.charAt(index) != board[m][n])return false;
		if(index == word.length() - 1)return true;
		int[][] dict = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		booleans[m][n] = true;
		boolean res = false;
		for (int j = 0; j < 4; j++) {
			int newM = m + dict[j][0];
			int newN = n + dict[j][1];
			if(newM < 0 || newM >= board.length || newN >= board[0].length || newN < 0 || booleans[newM][newN]){
				continue;
			}
			if(dfs(word,board,index + 1,booleans,newM,newN)){
				res = true;
				break;
			}
		}
		booleans[m][n] = false;
		return res;
	}
}
