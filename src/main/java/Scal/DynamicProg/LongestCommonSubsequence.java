package Scal.DynamicProg;

/*
Longest Increasing Subsequence

Problem Description
Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
In this case, return the length of the longest increasing subsequence.
*/
public class LongestCommonSubsequence {

    static int getLongestCommonSubsequence(int [] A){

        int n = A.length;
        int [] dp = new int [n];

        for (int i =0;i<n;i++){
            for (int j=0;j<i;j++){
                //compute if there is less element only
                if (A[j]< A[i]) {
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            //add current element contribution
            dp[i]++;
        }

        //compute highest value from dp array
        int ans=0;
        for (int a : dp){
            ans = Math.max(ans, a);
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] data = {1, 2, 1, 5};
        System.out.println(getLongestCommonSubsequence(data));

    }
}
