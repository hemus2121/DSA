package Scal.DynamicProg;

/**
 * Minimum Number Of Squares
 * Problem Description
 * <p>
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 */
public class MinimumNumberOfSquares {
    static int[] dp;

    private static int countSquares(int A) {
        dp = new int[A + 1];
        int iterAns = computeSquaresIterative(A);
        int recAns = computeSquaresRecur(A);
        System.out.println("iterative: " + iterAns + " recuAns:" + recAns);
        return iterAns;
    }

    private static int computeSquaresRecur(int A) {
        //Base case
        if (A == 0) return 0;
        if (dp[A] != 0) return dp[A];
        dp[A] = 1;
        int ans = Integer.MAX_VALUE;
        //compute
        for (int x = 1; (x * x) <= A; x++) {
            ans = Math.min(ans, computeSquaresRecur(A - (x * x)));
        }
        dp[A] += ans;
        return dp[A];
    }

    private static int computeSquaresIterative(int A) {
        if (A == 0) return 0;
        dp[0] = 1;
        dp[1] = 1;
        if (dp[A] != 0) return dp[A];

        for (int i = 2; i <= A; i++) {
            dp[i] = i;
            for (int x = 1; x * x <= i; x++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
            }
        }
        return dp[A];
    }

    public static void main(String[] args) {
        System.out.println(countSquares(6));// expected 3
    }
}
