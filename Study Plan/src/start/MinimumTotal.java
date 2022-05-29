package start;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/triangle/
 */
public class MinimumTotal {
	public static void main(String[] args) {
		MinimumTotal minimumTotal = new MinimumTotal();
		int[][] nums = {{2},{3,4},{6,5,7},{4,1,8,3}};
		List<List<Integer>> triangle = new ArrayList<>();
		for (int[] num : nums) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i : num) {
				list.add(i);
			}
			triangle.add(list);
		}
		int i = minimumTotal.solution1(triangle);
	}
	public int solution1(List<List<Integer>> triangle) {
		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if(j == 0){
					triangle.get(i).set(j,triangle.get(i-1).get(j) + triangle.get(i).get(j));
				}else if(j == triangle.get(i).size() - 1){
					triangle.get(i).set(j,triangle.get(i-1).get(j-1) + triangle.get(i).get(j));
				}else {
					int temp = Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j));
					triangle.get(i).set(j,temp + triangle.get(i).get(j));
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (Integer integer : triangle.get(triangle.size() - 1)) {
			ans = Math.min(ans,integer);
		}
		return ans;
	}

	public int solution2(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] f = new int[2][n];
		f[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; ++i) {
			int curr = i % 2;
			int prev = 1 - curr;
			f[curr][0] = f[prev][0] + triangle.get(i).get(0);
			for (int j = 1; j < i; ++j) {
				f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
			}
			f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
		}
		int minTotal = f[(n - 1) % 2][0];
		for (int i = 1; i < n; ++i) {
			minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
		}
		return minTotal;
	}

	public int solution3(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] f = new int[n];
		f[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; ++i) {
			f[i] = f[i - 1] + triangle.get(i).get(i);
			for (int j = i - 1; j > 0; --j) {
				f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
			}
			f[0] += triangle.get(i).get(0);
		}
		int minTotal = f[0];
		for (int i = 1; i < n; ++i) {
			minTotal = Math.min(minTotal, f[i]);
		}
		return minTotal;
	}


}
