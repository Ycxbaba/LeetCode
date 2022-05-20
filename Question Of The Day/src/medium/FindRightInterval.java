package medium;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
	public static void main(String[] args) {

	}

	//排序start
	public int[] solution1(int[][] intervals) {
		int len = intervals.length;
		int[][] start = new int[len][2];
		for (int i = 0; i < len; i++) {
			start[i][0] = intervals[i][0];
			start[i][1] = i;
		}
		Arrays.sort(start, Comparator.comparingInt(o -> o[0]));
		int[] ans = new int[len];
		for (int i = 0; i < len; i++) {
			int target = intervals[i][1];
			int left = 0,right = len - 1;
			int temp = -1;
			while (left <= right){
				int mid = (left + right)/2;
				if(start[mid][0] >= target){
					temp = start[mid][1];
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			ans[i] = temp;
		}
		return ans;
	}

	//排序start 和 end
	public int[] solution2(int[][] intervals) {
		int len = intervals.length;
		int[][] start = new int[len][2];
		int[][] end   = new int[len][2];
		for (int i = 0; i < len; i++) {
			start[i][0] = intervals[i][0];
			end[i][0]   = intervals[i][1];
			start[i][1] = end[i][1] = i;
		}
		Arrays.sort(start,Comparator.comparing(o -> o[0]));
		Arrays.sort(end,Comparator.comparing(o -> o[0]));

		int[] ans = new int[len];
		for (int i = 0 , j = 0; i < len; i++) {
			while (j < len && start[j][0] < end[i][0]){
				++j;
			}
			if(j < len){
				ans[end[i][1]] = start[j][1];
			}else {
				ans[end[i][1]] = -1;
			}
		}
		return ans;
	}
}
