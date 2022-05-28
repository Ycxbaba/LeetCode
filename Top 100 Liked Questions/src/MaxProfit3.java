/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class MaxProfit3 {
	public int solution(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		//当前持有股票,最大收益
		int f0 = -prices[0];
		//当前不持有股票,之后 是冷冻期 的最大收益
		int f1 = 0;
		//当前不持有股票,之后 不是冷冻期 的最大收益
		int f2 = 0;
		for (int i = 1; i < n; ++i) {
			//收益 可能是第i-1天就持有的 也可能是当天购买的
			int newf0 = Math.max(f0, f2 - prices[i]);
			//当天卖出,之后处于冷冻期,需要i-1天持有 当前卖出的收益
			int newf1 = f0 + prices[i];
			//不需要操作或者处于冷冻期不能操作
			int newf2 = Math.max(f1, f2);
			f0 = newf0;
			f1 = newf1;
			f2 = newf2;
		}
		return Math.max(f1, f2);
	}
}
