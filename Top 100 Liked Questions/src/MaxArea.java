/**
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class MaxArea {

	public static void main(String[] args) {

	}
	//双指针
	//时间复杂度 n 空间复杂度 1
	public int solution(int[] height) {
		int max = 0;
		int temp = 0;
		int left = 0;
		int right = height.length -1;
		while (left<right){
			if(height[right] >= height[left]){
				temp = height[left] * (right - left);
				++left;
			}else {
				temp = height[right] * (right - left);
				--right;
			}

			if(max < temp){
				max = temp;
			}

		}
		return max;
	}
}
