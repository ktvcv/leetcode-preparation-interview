package leetcode.easy;

import java.util.Arrays;

public class _121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProdfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for (final int price : prices) {
            buy = Math.min(buy, price);
            sell = Math.max(sell, price - buy);
        }
        return sell;
    }
}
