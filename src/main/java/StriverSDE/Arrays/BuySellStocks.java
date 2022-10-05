package StriverSDE.Arrays;

/** Buy Sell Stocks
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.*
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BuySellStocks {
    private static int maxProfit (int [] prices){

        int minPrice =Integer.MAX_VALUE, profit =0;
        // Iterate input array and get minimal till now
        for (int currPrice : prices){
            if (currPrice < minPrice){
                minPrice = currPrice;
            } else if( currPrice - minPrice > profit){
                profit = currPrice-minPrice;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int [] data = { 7,6,4,3,1};
        System.out.println(maxProfit(data)); //expected 0
    }
}
