import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/word-search/
 */
public class Exist {

	public static void main(String[] args) {
		Exist exist = new Exist();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";
		boolean solution = exist.solution(board, word);
		System.out.println(solution);
	}


	//回溯
	public boolean solution(char[][] board, String word) {
		boolean[][] boardMap = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//从 i , j 开始搜索 能不能找到
				if (back(board,i,j,0,word,boardMap)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean back(char[][] board,int row,int col,int index,String word,boolean[][] boardMap){
		//要先判断 字母对不对 , 否者将会直接返回 true
		if(board[row][col] != word.charAt(index))return false;
		//在判断是否最后一个
		if(index == word.length() - 1)return true;
		//记录位置 ， 不可重复
		boardMap[row][col] = true;
		//上下左右搜索
		int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] direction : directions) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];
			//不能越界 不可重复搜索
			if( newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length && !boardMap[newRow][newCol]){
				if (back(board,newRow,newCol,index+1,word,boardMap)){
					return true;
				}
			}
		}
		//没找到 ， 释放位置
		boardMap[row][col] = false;
		return false;
	}
}
