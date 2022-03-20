package Scal.DynamicProg.TwoDArray;

/*
Problem Description
Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.
 */

public class MaximumSumWithoutAdjacentElements {

    private static int getMaxSum(int [][]A){
        int n = A[0].length;
        int [] AR = new int[n];

        //generate 1 D array with maximum elements from both rows- critical
        for (int i =0;i<n;i++){
            AR[i] = Math.max(A[0][i], A[1][i]);
        }
        int [] dp = new int [ n+1];
        //return computeRecursion(AR,n, dp);
        return computeWithoutRecursion(AR,n,dp);
    }

    //Sol1 - Bottom up approach
    private static int computeWithoutRecursion(int []AR, int n, int []dp){
        if (n==0) return 0;
        dp[0] = AR[0];
        if (n<2) return  dp[0];
        dp[1]= AR[1];
        for (int i=2;i<n;i++){
            dp[i]= Math.max(AR[i]+ dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }

    //Sol2 - Topdown approach
    private static int computeRecursion(int []AR,int n, int []dp){
        if (n==0) return 0;
        if (n==1) return AR[0];
        if (dp[n] !=0) return dp[n];
        //compute
        int exclude = computeRecursion(AR, n-1, dp);
        int include = AR[n-1]+computeRecursion(AR,n-2,dp);
        dp[n] = Math.max(include, exclude);
        return dp[n];
    }

    public static void main(String[] args) {
        int [][] data = new int [][] {
                {14,87,36,23},
                {37,59,21,68}
        };
        System.out.println(getMaxSum(data));

    }
}
