package start;

/**
 * https://leetcode.cn/problems/flood-fill/
 */
public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		dfs(image,sr,sc,newColor,image[sr][sc]);
		return image;
	}
	private void dfs(int[][] image, int sr, int sc, int newColor,int oldColor){
		//防止新颜色与旧颜色一样导致栈溢出
		if(image[sr][sc] != oldColor || image[sr][sc] == newColor)return ;
		image[sr][sc] = newColor;
		int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
		for (int[] ints : direct) {
			int newSr = sr + ints[0];
			int newSc = sc + ints[1];
			if(newSc >= 0 && newSr >=0 && newSr < image.length && newSc <image[0].length){
				dfs(image,newSr,newSc,newColor,oldColor);
			}
		}
	}
}


