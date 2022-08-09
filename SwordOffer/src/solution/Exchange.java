package solution;

/**
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Exchange {
	public int[] exchange(int[] nums) {
		int[] ans = new int[nums.length];
		int m = 0;
		int n = nums.length - 1;
		for (int num : nums) {
			if ((num & 1) == 1) {
				ans[m++] = num;
			} else {
				ans[n--] = num;
			}
		}
		return ans;
	}

	public int[] exchange1(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		while (l < r){
			//找到一个偶数
			while (l < r){
				if((nums[l] & 1) == 0)break;
				l++;
			}
			//找到一个奇数
			while (l < r){
				if((nums[r] & 1) == 1)break;
				r--;
			}
			//采用异或交换要避免 l=r
			if(l >= r)return nums;
			//交换
			nums[l] = nums[r] ^ nums[l];
			nums[r] = nums[r] ^ nums[l];
			nums[l] = nums[r] ^ nums[l];

		}
		return nums;
	}

	public static void main(String[] args) {
		Exchange exchange = new Exchange();
		exchange.exchange1(new int[]{
				1,2,3,4});
	}

}
