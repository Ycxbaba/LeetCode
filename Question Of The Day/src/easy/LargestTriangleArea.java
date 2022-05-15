package easy;

/**
 * https://leetcode.cn/problems/largest-triangle-area/
 */
public class LargestTriangleArea {
	public static void main(String[] args) {
		LargestTriangleArea largestTriangleArea = new LargestTriangleArea();
		int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
		System.out.println(largestTriangleArea.solution(points));
	}

	//暴力
	public double solution(int[][] points) {
		double maxArea = 0.0;
		int len = points.length;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				for (int k = j+1; k < len; k++) {
					maxArea = Math.max(maxArea,calculate(points[i],points[j],points[k]));
				}
			}
		}
		return maxArea;
	}

	private double calculate(int[] x,int[] y,int[] z){
		return 0.5 * Math.abs( (x[0] - z[0]) * (y[1] - z[1]) - (x[1] - z[1]) * (y[0] - z[0]));
	}
}
