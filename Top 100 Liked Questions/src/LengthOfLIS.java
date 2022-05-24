/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {
	public static void main(String[] args) {
		LengthOfLIS lengthOfLIS = new LengthOfLIS();
		int[] nums = {1,3,6,7,9,4,10,5,6};
		int i = lengthOfLIS.solution1(nums);
		System.out.println(i);
	}
	public int solution1(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = 1;
		int ans = 1;
		for (int i = 1; i < len; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]){
					max = Math.max(dp[j],max);
				}
			}
			dp[i] = max + 1;
			ans = Math.max(dp[i],ans);
		}
		return ans;
	}

	public int solution2(int[] nums) {
		int len = 1,n=nums.length;
		if(n == 0)return 0;
		int[] d = new int[n+1];
		d[len] = nums[0];
		for (int i = 1; i < n; i++) {
			if(nums[i] > d[len]){
				d[++len] = nums[i];
			}else {
				int left = 1 , right = len , pos = 0;
				while (left <= right){
					int mid = (left + right)>>1;
					if(d[mid] < nums[i]){
						pos = mid;
						left = mid + 1;
					}else {
						right = mid - 1;
					}
				}
				d[pos + 1] = nums[i];
			}
		}
		return len;
	}

}
