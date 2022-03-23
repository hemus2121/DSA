package Scal.DynamicProg.TwoDArray;

/*
Longest Common Subsequence

Problem Description

Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
You need to return the length of such longest common subsequence.
 */

// Reference
// https://leetcode.com/problems/longest-common-subsequence/discuss/1854201/Java%3A-From-Brute-force-to-DP-Printing-of-LCS-also-included.

//https://leetcode.com/problems/longest-common-subsequence/discuss/1833377/Java-DP-solution-Explained
public class LongestCommonSubsequence {
    private static  int getCommonLength(String A, String B){
        int [] [] lcs = new int [A.length()][B.length()];
        //return computeRecursion(A, B, A.length()-1,B.length()-1, lcs);
        return computeIteration(A, B);
    }


    //Soln 1- Using TOPDOWN approach
    static int computeRecursion(String A, String B, int i, int j, int [][]lcs){

        //BASE CASE
        if (i==-1 || j ==-1) return 0;

        // Already found in cache return It
        if (lcs [i][j] !=0) return  lcs [i][j];

        //compute
        if (A.charAt(i)== B.charAt(j)){
            lcs[i][j] = 1+ computeRecursion(A, B, i-1, j-1, lcs);
        }else {
            lcs[i][j] = Math.max(computeRecursion(A, B, i-1,j, lcs),
                                 computeRecursion(A, B, i, j-1, lcs));
        }
        return lcs[i][j];
    }

    //Sol2 - using BOTTOM UP approach
    static int computeIteration(String A, String B){

        int m=A.length();
        int n=B.length();
        // this is important
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(A.charAt(i-1)==B.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];   // if chars are same then we just have to add 1 to previous count
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);   // relating this condition with recursive approach might be easy to understand
                }
            }
        }

        //to print answer from matrix- traversing back from last cell in the matrix
        String ans="";
        int i = m; int j =n;
        while (i>0 && j >0){
            if (A.charAt(i-1)==B.charAt(i-1)){
                ans = A.charAt(i-1)+ans;
                i =i-1;
                j = j-1;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i= i-1;
            } else j =j-1;
        }
        System.out.println(ans);
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println( getCommonLength("kaiya","maica"));
        //System.out.println(getCommonLength("bebdeeedaddecebbbbbabebedc","abaaddaabbedeedeacbcdcaaed"));
       // System.out.println(getCommonLength("ab","da"));
        //System.out.println(getCommonLength("caababcebaeadeaaeeacbcbcabdaacdceadebcedcaacbbeacacaeacbcccebcdbcdababeedbbbccbecbeedeaa","caababcebaeadeaaeeacbcbcabdaacdceadebcedcaacbbeacacaeacbcccebcdbcdababeedbbbccbecbeedeaa"));
    }
}
