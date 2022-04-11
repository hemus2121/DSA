package Scal.DynamicProg;

import java.util.Arrays;
/*
Problem Description

Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
In this case, return the length of the longest increasing subsequence.
 */

public class LongestIncreasingSubsequence {

    private static int getLength(int []A){
        int n = A.length;
        if (A == null  || n==0)
            return 0;

        int[] dp = new int[n];
        //Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }
        int res = 0;
        for (int i : dp)
            res = Math.max(res, i);
        return res;
    }

    public static void main(String[] args) {
        int [] data = {1};
        System.out.println(getLength(data));

    }
}
