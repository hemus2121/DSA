package Visa.DynamicProgramming;
/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 */

import java.util.Arrays;
 // using MEMORISATION
public class LongestIncreasingSubMemo {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][]=new int[n][n+1]; /// to handle negative index stuff
        for (int [] row : dp)
            Arrays.fill (row, -1);
        return getAns(nums,n, 0 , -1,  dp);
    }

    private static int getAns(int [] nums,int n, int ind, int prev_ind, int [][] dp){
        //base case
        if (ind == n )return 0;

        if (dp [ind][prev_ind+1] != -1) return  dp[ind][prev_ind+1];

        int notTake = getAns(nums, n, ind+1, prev_ind, dp);

        int take =0;
        if ( prev_ind ==-1 || nums [ind] > nums[prev_ind]){
            take = 1 + getAns(nums, n, ind+1, ind, dp);
        }
        return dp [ind][prev_ind+1]= Math.max(notTake, take);
    }

    public static void main(String[] args) {
        int [] data = { 0,1,0,3,2,3};
        System.out.println(lengthOfLIS(data));
    }
}
