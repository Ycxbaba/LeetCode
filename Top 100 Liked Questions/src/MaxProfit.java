/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
	public static void main(String[] args) {

	}

	public int solution(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int price : prices) {
			if (price < min) {
				min = price;
			} else if (price - min > maxProfit) {
				maxProfit = price - min;
			}
		}
		return maxProfit;
	}
}
