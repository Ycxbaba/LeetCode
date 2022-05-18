import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 */
public class LongestConsecutive {
	public static void main(String[] args) {

	}
	public int solution(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		//考虑 nums 为 null 和 空 的情况
		int max = 0;
		for (Integer integer : set) {
			//包含跳过 对于遍历到 2 来说 1 2 3 4 肯定 要比 2 3 4 长
			if(!set.contains(integer - 1)){
				int current = integer;
				int len = 1;
				while (set.contains(current + 1)){
					current++;
					len ++;
				}
				max = Math.max(len,max);
			}
		}
		return max;
	}

	//动态规划
	public int solution2(int[] nums) {
		// key表示num，value表示num所在连续区间的长度
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int num : nums) {
			// 当map中不包含num，也就是num第一次出现
			if (!map.containsKey(num)) {
				// left为num-1所在连续区间的长度，更进一步理解为：左连续区间的长度
				int left = map.getOrDefault(num - 1, 0);
				// right为num+1所在连续区间的长度，更进一步理解为：右连续区间的长度
				int right = map.getOrDefault(num + 1, 0);
				// 当前连续区间的总长度
				int curLen = left + right + 1;
				ans = Math.max(ans, curLen);
				// 将num加入map中，表示已经遍历过该值。其对应的value可以为任意值。
				map.put(num, -1);
				// 更新当前连续区间左边界和右边界对应的区间长度
				map.put(num - left, curLen);
				map.put(num + right, curLen);
			}
		}
		return ans;
	}
}
