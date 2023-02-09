package Visa.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubTab {
    private static int lengthOfLIS(int [] nums){
        int n = nums .length;
        //return getAns(nums,n);
       // return getAnsOpt(nums,n);
        return getAnsMostOpt(nums, n);
    }
    private static  int getAns(int [] nums, int n ){
        int [][] dp = new int [n+1][n+1];
        //we need to go from i.e index n-1 to 0
        //  prev ind goes from ind-1 to -1;
        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){
                int notTake = 0 + dp[ind+1][prev_index +1];

                int take = 0;
                if(prev_index == -1 || nums[ind] > nums[prev_index]){
                    take = 1 + dp[ind+1][ind+1];
                }
                dp[ind][prev_index+1] = Math.max(notTake,take);
            }
        }
        return dp[0][0];
    }

    private static  int getAnsOpt(int [] nums, int n ){
        int [] cur  = new int [n+1];
        int [] next = new int [n+1];

        //we need to go from i.e index n-1 to 0
        //  prev ind goes from ind-1 to -1;
        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){
                int notTake = 0 + next[prev_index +1];

                int take = 0;
                if(prev_index == -1 || nums[ind] > nums[prev_index]){
                    take = 1 + next[ind+1];
                }
               cur[prev_index+1] = Math.max(notTake,take);
            }
            next = cur.clone();
        }
        return cur[0];
    }

    private static  int getAnsMostOpt(int [] nums, int n ){
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max =0;
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                if(nums[prev_index]<nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return  max;
    }
    public static void main(String[] args) {
        int [] data = { 0,1,0,3,2,3};
        System.out.println(lengthOfLIS(data));
    }
}
