package leetcode.medium;

//You are given an integer array prices where prices[i]
// is the price of a given stock on the ith day.
//
//On each day, you may decide to buy and/or sell the stock.
// You can only hold at most one share of the stock at any time.
// However, you can buy it then immediately sell it on the same day.
//
//Find and return the maximum profit you can achieve.
public class _122_BestTimetoBuyAndSellStockII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
    public static int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0, total = 0;
        for (int i = 0; i < prices.length;) {
            final int price = prices[i];
            buy = Math.min(buy, price);
            sell = Math.max(sell, price - buy);
            if (sell > 0) {
                total += sell;
                buy = Integer.MAX_VALUE;
                sell = 0;
            }else {
                i++;
            }
        }
        return total;
    }
}

