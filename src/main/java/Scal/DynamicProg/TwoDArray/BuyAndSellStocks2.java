package Scal.DynamicProg.TwoDArray;

/** Best Time to Buy and Sell Stock II
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */

import java.util.Arrays;

public class BuyAndSellStocks2 {

    static long getMaximumProfit(long Arr[], int n) {
        //Write your code here
        long dp[][] = new long[n + 1][2];
        for (long row[] : dp)
            Arrays.fill(row, -1);

        //base condition
        dp[n][0] = dp[n][1] = 0;
        long profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {// We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) {// We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }

    public static void main(String args[]) {
        int n = 6;
        long Arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
    }
}
