package Scal.DynamicProg;

import Scal.Stacks.MAXandMIN;

/* Longest Common Subsequence
Problem Description
Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
You need to return the length of such longest common subsequence.

LCS(i, j) = maximum (LCS(i-1, j-1] + 1,       //if(A[i] = B[j])
                     LCS(A[i-1], B[j],
                     LCS(A[i], B[j-1] )
*/
public class LongestCommonSubsequence {

    static int [] [] lcs ;

    static int[][] memo;
    static String text1;
    static String text2;

    static int getLongestCommonSubsequence(String text1, String text2){
       // return getLCS(A, B);
       // lcs = new int[A.length()][ B.length()];
        //return getLCSRec(A,B, A.length()-1, B.length()-1);

        // Make the memo big enough to hold the cases where the pointers
        // go over the edges of the strings.
        memo = new int[text1.length() + 1][text2.length() + 1];
        // We need to initialise the memo array to -1's so that we know
        // whether or not a value has been filled in. Keep the base cases
        // as 0's to simplify the later code a bit.
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        LongestCommonSubsequence.text1 = text1;
        LongestCommonSubsequence.text2 = text2;
        return memoSolve(0, 0);
    }

    private static int memoSolve(int p1, int p2) {
        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        // Recursive cases.
        int answer = 0;
        if (text1.charAt(p1) == text2.charAt(p2)) {
            answer = 1 + memoSolve(p1 + 1, p2 + 1);
        } else {
            answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
        }

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = answer;
        return memo[p1][p2];
    }
    private static int getLCSRec(String a, String b, int i, int j){

        // BAse case
        if (i== -1 || j == -1) return 0;

        if (lcs[i][j] != 0) return lcs[i][j];
        //compute
        if (a.charAt(i)== b.charAt(j)){
            lcs[i][j] = 1+ getLCSRec(a, b, i-1,j-1);
        }else {
            lcs[i][j] = Math.max(getLCSRec(a, b, i-1, j), getLCSRec(a,b,i, j-1));
        }
        return lcs[i][j];
    }

    private static int getLCS(String a, String b) {
        int m = a.length();
        int n = b.length();
        int [][]  dpArray = new int[m+1][n+1]; //create 2D -dp array

        //iterate both strings comparing character by character
        for( int i=1;i<= m;i++){
            for (int j =1;j<= n;j++){
                if (a.charAt(i-1)== b.charAt(j-1) ){
                    //common characters found --> 1+ diagonal value in dp array
                    dpArray[i][j] = 1+ dpArray[i-1][j-1];
                }else {
                    // no common character  --> max from either top or left
                    dpArray[i][j] = Math.max(dpArray[i-1][j], dpArray[i][j-1]);
                }
            }
        }
        return dpArray[m][n];
    }

    public static void main(String[] args) {
        String A= "abcde";
        String B ="ace";
        System.out.println(getLongestCommonSubsequence(A, B));// expected 5

    }
}
