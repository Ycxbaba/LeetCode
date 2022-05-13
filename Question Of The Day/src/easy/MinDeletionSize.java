package easy;

/**
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
public class MinDeletionSize {
	public static void main(String[] args) {
		MinDeletionSize minDeletionSize = new MinDeletionSize();
		String[] strings = {"cba", "daf", "ghi"};
		System.out.println(minDeletionSize.solution(strings));
	}

	public int solution(String[] strs) {
		if (strs.length <= 1)return 0;
		int len = strs[0].length();
		int ans = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) < strs[j-1].charAt(i)) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}
}
