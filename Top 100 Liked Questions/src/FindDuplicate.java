/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 */
public class FindDuplicate {
	public static void main(String[] args) {

	}
	//二分查找，取 1 - n 的中间值，计算小于等于中间值的数
	public int solution1(int[] nums) {
		int l = 0 , r = nums.length - 1;
		int ans = 0;
		while (l <= r){
			int mid = (l + r)>>1;
			int cnt = 0;
			for (int num : nums) {
				if (num <= mid) {
					cnt++;
				}
			}
			if(cnt <= mid){
				l = mid + 1;
			}else {
				ans = mid;
				r = mid - 1;
			}
		}
		return ans;
	}

	//快慢指针指针 --- 因为有重复元素 ，所以会呈环状
	//理解为有环的链表，那么就可以参考之前的问题了，
	public int solution2(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
