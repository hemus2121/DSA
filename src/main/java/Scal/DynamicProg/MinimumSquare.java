package Scal.DynamicProg;
/*
Problem Description

Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 */
public class MinimumSquare {

    public static int solve(int n){
        int[] dp = new int [n+1];
        return  compute(n,dp);
    }
    private static int compute (int n, int [] dp){
        //base case
        if (n==0) return 0;

        //already found in array
        if (dp[n]!=0) return dp[n];

        //compute if since its not found
        dp[n]=1;
        int ans = Integer.MAX_VALUE;
        for (int x=1;x*x <=n;x++){
            ans = Math.min(ans, compute(n-(x*x), dp));
        }
        dp[n] +=ans;
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(solve(6));
    }
}
