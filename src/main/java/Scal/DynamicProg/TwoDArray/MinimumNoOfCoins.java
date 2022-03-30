package Scal.DynamicProg.TwoDArray;
/*
Problem Description: Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

https://leetcode.com/problems/coin-change/discuss/1806365/Recursive-greater-Recursive%2BMemo-(TOP-DOWN)-greater-Iterative%2BMemo(BOTTOM-UP)
 */
public class MinimumNoOfCoins {
    static int getMinimumCoinChange(int []coins, int amount){

        int dp[][]=new int[coins.length+1][amount+1];

         /* Now, when we need amount 0, and if we have array size 0,1,2,3... etc. can we make
            amount 0 ? Yes we can make by not adding any element. So just add 0 in them.
        */
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=0;
        }

         /* j here is amount, and i is size of coins array, now when size of array is 0
            whats the minimum element we will need to make amount 1,2... etc , answer is we cannot make as there is no element present or we will need infinite number of elements
            so just add Integer.MAX_VALUE;
         */
        for(int j=1;j<=amount;j++) {
            dp[0][j]=Integer.MAX_VALUE;
        }

        for(int i=1;i<=coins.length;i++) {
            for(int j=1;j<=amount;j++) {
                if(coins[i-1]<=j) {
                    if(dp[i][j-coins[i-1]] != Integer.MAX_VALUE) //check this because we cannot add 1 to MAXVAL.
                      dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                    else
                        dp[i][j]=dp[i-1][j]; //if the above condition is maxVal obvio we our dp[i-1][j] will be smaller.
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount]>amount ? -1:dp[coins.length][amount];
    }

    // TOPDOWN approach
    static int getMinimumCoinChangeRecur(int [] coins,int sum){
       int [][] dp = new int[coins.length+1][sum+1];

        int ans = countMinCoins(coins, sum, coins.length-1, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

    static int countMinCoins(int [] coins, int sum , int n, int [][] dp){
        //Base Case
        if (n<0  || sum <0) return Integer.MAX_VALUE;
        if (sum==0) return 0;

        //check in cache
        //if dp val isnt -1 means we have filled it already to return it
        if (dp[n][sum] !=0)return dp[n][sum];

        //compute
        // case where coin is REJECTED
        int notPicked = countMinCoins(coins, sum - coins[n], n, dp);
        if (notPicked != Integer.MAX_VALUE) notPicked +=1;

        // case where coin is SELECTED
        int picked = countMinCoins(coins,sum, n-1, dp);

        //store the min val at our current position (n, sum) and return it.
        return dp[n][sum] = Math.min(notPicked, picked);
    }

    public static void main(String[] args) {
        int [] coins = {1, 2, 5};
        System.out.println(getMinimumCoinChange(coins,11));
        System.out.println(getMinimumCoinChangeRecur(coins,11));
    }


}
