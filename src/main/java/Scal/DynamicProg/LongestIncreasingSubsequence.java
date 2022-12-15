package Scal.DynamicProg;


/* Longest increasing subsequence
Problem Description

Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
In this case, return the length of the longest increasing subsequence.
 */

public class LongestIncreasingSubsequence {

    private static int getLength(int []A){
        int n = A.length;
        int [] dp = new int [n];
        int maxCount=-1;
        //lets iterate input array elements
        for (int i=0;i<n;i++){
            for (int j =0;j<i;j++){
                //check for smaller elements
                if (A[j] < A[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++; //add +1 for previous value to account for current element
            maxCount = Math.max(maxCount, dp[i]);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int [] data = {1,2, 3,1, 6};
        System.out.println(getLength(data));
    }
}
