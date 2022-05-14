import java.util.*;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
public class Merge {

	public static void main(String[] args) {
		Merge merge = new Merge();
		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
	}

	public int[][] solution(int[][] intervals) {
		int len = intervals.length;
		if(len == 0)return new int[0][2];
		List<int[]> ans = new ArrayList<>();
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		for (int[] interval : intervals) {
			int L = interval[0], R = interval[1];
			if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < L) {
				ans.add(new int[]{L, R});
			} else {
				ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], R);
			}
		}
		return ans.toArray(new int[0][]);
	}

	//评论区大佬的东西
	//大概就是将区间再数轴上模拟，在重新找区间
	public int[][] solution_nb(int[][] intervals) {
		BitSet bitSet = new BitSet();
		int max = 0;
		for (int[] interval : intervals) {
			//这里 * 2 + 1 的目的是为了使得如 [3,3],[2,2] 不会发生下面的情况
			/*
			   源码部分
			   public void set(int fromIndex, int toIndex) {
			          checkRange(fromIndex, toIndex);

			          if (fromIndex == toIndex)
			              return;
			 */
			int temp = interval[1] * 2 + 1;
			bitSet.set(interval[0] * 2, temp, true);
			max = Math.max(temp, max);
		}

		int index = 0, count = 0;
		while (index < max) {
			int start = bitSet.nextSetBit(index);
			int end = bitSet.nextClearBit(start);

			int[] item = {start / 2, (end - 1) / 2};
			intervals[count++] = item;

			index = end;
		}
		int[][] ret = new int[count][2];
		System.arraycopy(intervals, 0, ret, 0, count);

		return ret;
	}


}
