package Scal.DynamicProg.TwoDArray;

/** Best Time to Buy and Sell Stock IV
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BuyAndSellStocks4 {

    static int stockProfit(int[] Arr, int n, int k) {
        int dp[][][] = new int[n + 1][2][k+1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {

                    if (buy == 0) {// buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap], -Arr[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) {//sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap], Arr[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }

    public static void main(String args[]) {
        int prices[] = {3,3,5,0,0,3,1,4};
        int n = prices.length;
        int k =2 ;
        System.out.println("The maximum profit that can be generated is " + stockProfit(prices, n,k));
    }
}
