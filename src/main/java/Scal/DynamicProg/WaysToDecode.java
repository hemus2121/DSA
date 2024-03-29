package Scal.DynamicProg;

/** Ways To Decode
 * Problem Description
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
 */
public class WaysToDecode {
    static int mod = (int) Math.pow(10,9)+7;
    private static int getWays(String A){
        int n = A.length();
        int [] dp = new int[n+1];
        if (A== null || A=="")return 0;
        //return decodeRecur(A, 0, dp);
        return iterative (A,dp);
    }

    //https://leetcode.com/problems/decode-ways/discuss/1823526/Simple-Java-Recursion-Memoization-Tabulation
    //Sol1 - TOPDOWN - Recursive
    static int decodeRecur(String A, int i, int [] dp){
        if (i==A.length()) return 1; // If you reach the end of the string  Return 1 for success.
        if (A.charAt(i)=='0') return 0;  // If the string starts with a zero, it can't be decoded
        if (i==A.length()-1) return 1; //

        if (dp[i]!=0) return  dp[i]; // already present in memorisation

        dp[i+1] = decodeRecur(A, i+1, dp);

        //number of ways for the given string is determined by making a recursive call to the function with index + 1 for next substring string and index + 2 after checking for valid 2-digit decode.
        dp[i+2] =0;

        if (Integer.parseInt(A.substring(i, i+2))<=26){
            dp[i+2] = decodeRecur(A, i+2,dp);
        }
        return  dp[i+1]+ dp[i+2];
    }

    //Sol2 - BOTTOM UP - Iterative
    static int iterative(String A, int []dp) {
        //dp[0] = 1; // when String is empty
        dp[1] = 1; // single character has 1 decoding possible
        int n = A.length();

        for (int i = 2; i <= n; i++) {

            //first gets LSB  and second gets whole number
            int singleCharacter = Integer.valueOf(A.substring(i - 1, i));
            int doubleCharacter = Integer.valueOf(A.substring(i - 2, i)); // this coverts anyting starting with 0 to actual number

            if (singleCharacter > 0 && singleCharacter <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % mod;
            }

            //check the second number from 9 to 29 which is range for next set of numbers
            if (doubleCharacter > 9 && doubleCharacter <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
        }
        return dp[n] % mod;
    }

    public static void main(String[] args) {
        System.out.println(getWays("00"));
    }
}
