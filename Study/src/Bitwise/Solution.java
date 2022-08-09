package Bitwise;

public class Solution {
	//只出现一次的数字，其他出现两次
	private void appearOnce(int[] nums){
		int ans = 0;
		for (int num : nums) {
			ans ^= num;
		}
		System.out.println(ans);

	}

	//只出现一次的数字有两个，其他出现两次
	private void appearTwice(int[] nums){
		int eor = 0;
		for (int num : nums) {
			eor ^= num;
		}
		int eor1 = eor ;
		int temp = eor & (~eor + 1);
		for (int num : nums) {
			if ((num & temp) == temp) {
				eor1 ^= num;
			}
			// if ((num & temp) == 0) {
			// 	eor1 ^= num;
			// }
		}
		eor ^= eor1;
		System.out.printf("第一个数为{%s},第二个数为{%s}%n", eor,eor1);

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// solution.appearTwice(new int[]{1,2,5,5,6,6,2,3});
		System.out.println(7 & 6);
	}
}
