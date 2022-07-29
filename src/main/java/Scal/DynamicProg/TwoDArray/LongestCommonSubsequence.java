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
//https://leetcode.com/problems/longest-common-subsequence/discuss/1252871/DP-Java-Sol-or-Bruteforce-%2B-Optimized-Approach - Recursion
public class LongestCommonSubsequence {
    private static  int getCommonLength(String A, String B){
        int m = A.length();
        int n = B.length();
        int [] [] lcs = new int [A.length()+1][B.length()+1];
        //return computeRecursion(A, B, m,n, lcs);
        //return computeIteration(A, B);
        System.out.println("recursion:" +computeRecursion(A, B, m,n, lcs) + " Iterative:" +computeIteration(A,B) );
        return computeRecursion(A, B, m,n, lcs);
    }


    // TOPDOWN
    static int computeRecursion(String A, String B, int m, int n, int [][]lcs){

        //BASE CASE
        if (m==0 || n ==0) return 0;

        // Already found in cache return It
        if (lcs [m][n] !=0) return  lcs [m][n];

        //compute
        if (A.charAt(m-1)== B.charAt(n-1)){
            lcs[m][n] = 1+ computeRecursion(A, B, m-1, n-1, lcs);
        }else {
            lcs[m][n] = Math.max(computeRecursion(A, B, m-1,n, lcs),
                                 computeRecursion(A, B, m, n-1, lcs));
        }
        return lcs[m][n];
    }

    //BOTTOM UP
    static int computeIteration(String A, String B){

        int m=A.length();
        int n=B.length();
        // this is important
        int[][] dp = new int[m+1][n+1];

        //compute 1st column values
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }

        //compuate 1st row values
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
        //this works ONLY if both string length are SAME
//        String ans="";
//        int i = m; int j =n;
//        while (i>0 && j >0){
//            if (A.charAt(i-1)==B.charAt(i-1)){
//                ans = A.charAt(i-1)+ans;
//                i =i-1;
//                j = j-1;
//            }else if(dp[i-1][j]>dp[i][j-1]){
//                i= i-1;
//            } else j =j-1;
//        }
//        System.out.println(ans);
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println( getCommonLength("abcde","aceda")); //expected 3
        //System.out.println(getCommonLength("bebdeeedaddecebbbbbabebedc","abaaddaabbedeedeacbcdcaaed"));
       // System.out.println(getCommonLength("ab","da"));
        //System.out.println(getCommonLength("caababcebaeadeaaeeacbcbcabdaacdceadebcedcaacbbeacacaeacbcccebcdbcdababeedbbbccbecbeedeaa","caababcebaeadeaaeeacbcbcabdaacdceadebcedcaacbbeacacaeacbcccebcdbcdababeedbbbccbecbeedeaa"));
    }
}
