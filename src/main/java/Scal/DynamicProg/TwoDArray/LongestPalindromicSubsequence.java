package Scal.DynamicProg.TwoDArray;

/*
Longest Palindromic Subsequence
Problem Description
Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
You need to return the length of longest palindromic subsequence.

Problem Constraints 1 <= length of(A) <= 103
*/

public class LongestPalindromicSubsequence {
    private static int getPalinLength(String A){
        int length = A.length();
        int [][] dp = new int [length+1][length+1];
        return calculateRecursive (A.toCharArray(), 0, length-1,dp);
       // return  computePalinCostIteration(A.toCharArray());
    }

    static int calculateRecursive(char[] str ,int start,int end, int [][] dp){
        // Base cases
        if (start > end ) return 0;
        if (start == end ) return 1;

        if (dp [start][end]!=0) return dp[start][end];

        if (str[start]== str[end]){
            // both characters match so length =2 + compute for remainig from both ends
            dp[start][end] = 2+ calculateRecursive(str, start+1, end-1,dp);
        }else {
            // check excluding end character
            dp[start][end] = Math.max(calculateRecursive(str, start, end-1, dp),
                    calculateRecursive(str,start+1, end, dp)); // check excluding start character
        }
        return dp[start][end];
    }

    // using Bottom up Approach
    //
    static int computePalinCostIteration(char [] A) {
        int [][] dp= new int[A.length+1][A.length+1];

        for(int i=0; i < A.length; i++){
            dp[i][i] = 1;
        }

        for(int l = 2; l <= A.length; l++){
            for(int i = 0; i < A.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && A[i] == A[j]){
                    dp[i][j] = 2;
                }else if(A[i] == A[j]){
                    dp[i][j] = dp[i + 1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        //answer is stored at [1][n-1] location
        return dp[0][A.length-1];
    }
    public static void main(String[] args) {
        System.out.println(getPalinLength("bebeeed"));
    }
}
