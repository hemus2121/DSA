package Scal.DynamicProg.TwoDArray;

//https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42213/Easiest-Java-DP-Solution-(97.36)

public class hw_q2_Palindrome_Partitioning_II {
    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        // build the dp matrix to hold the palindrome information
        // dp[i][j] represents whether s[i] to s[j] can form a palindrome
        boolean[][] dp = buildMatrix(s, n);

        // res[i] represents the minimum cut needed
        // from s[0] to s[i]
        int[] res = new int[n];

        for (int j = 0; j < n; j++) {
            // by default we need j cut from s[0] to s[j]
            int cut = j;

            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    // s[i] to s[j] is a palindrome
                    // try to update the cut with res[i - 1]
                    cut = Math.min(cut, i == 0 ? 0 : res[i - 1] + 1);
                }
            }

            res[j] = cut;
        }

        return res[n - 1];
    }

    static boolean[][] buildMatrix(String s, int n) {
        boolean[][] dp = new boolean[n][n];

        // 0 1 2 3 4 5  i =0 j=1
        // b b d a d b
        for (int row = n - 1; row >= 0; row--) {
            for (int col = row; col < n; col++) {
                if (s.charAt(row) == s.charAt(col) && ( col-row <=2  || dp[row + 1][col - 1])) {
                    dp[row][col] = true;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        hw_q2_Palindrome_Partitioning_II obj = new hw_q2_Palindrome_Partitioning_II();
        System.out.println(obj.minCut("anaconoaa")); // 2
       // obj.minCut("cbcdecbc"); // 3
    }
}