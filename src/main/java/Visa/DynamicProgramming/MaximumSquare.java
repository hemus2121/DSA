package Visa.DynamicProgramming;

//https://leetcode.com/problems/maximal-square/description/
public class MaximumSquare {

    public int maximalSquare(char[][] matrix) {
        // base case
        if (matrix == null || matrix.length==0 ||matrix[0].length==0){
            return 0;
        }

        int max =0, n = matrix.length, m = matrix[0].length;

       // BOTTOM UP approach

        int[] [] dp = new int [n+1][m+1];
        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1)

        for (int i =1;i <=n;i++){
            for (int j =1;j<=m;j++){
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) +1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        // we need to return square area
        return  max*max;
    }

}
