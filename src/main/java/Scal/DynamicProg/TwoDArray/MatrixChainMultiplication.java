package Scal.DynamicProg.TwoDArray;

//https://leetcode.com/discuss/general-discussion/1278305/all-about-matrix-chain-multiplication-easy

import java.util.Arrays;

public class MatrixChainMultiplication {
    private static int compute(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        // return computeMinCostRecursion(A, 1, n-1, dp);
        return computeMinCostIteration(A, n, dp);
    }

    // using TOPDown approach
    static int computeMinCostRecursion(int[] A, int i, int j, int[][] dp) {
        // base case
        if (i == j) return 0;
        // already found in cache
        if (dp[i][j] != 0) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], computeMinCostRecursion(A, i, k, dp) + computeMinCostRecursion(A, k + 1, j, dp) + A[i - 1] * A[j] * A[k]);
        }
        // this is nothing but the [i] [n-1]where value is stored
        return dp[i][j];
    }

    // using Bottom up Approach
    static int computeMinCostIteration(int[] A, int n, int[][] dp) {

        // start from bottom row to top row
        for (int i = n; i >= 1; i--) {
            // start from left column to right column
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + A[i - 1] * A[j] * A[k]);
                }
            }
        }
        //answer is stored at [1][n-1] location
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] A = {40, 20, 30, 10, 30};
        int[] AA = {10, 20, 30};
        System.out.println(compute(A));
        System.out.println(compute(AA));
    }

}
