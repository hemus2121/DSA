package visa.DynamicProgramming;

//https://leetcode.com/problems/minimum-falling-path-sum/description/

public class MinimumFallingPathSum {
    public int  minFallingPathSum(int [][]matrix){
        int [][] dp = new int [matrix.length][matrix.length];
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        //copy 1st row as it is since that is minimum
        for (int i =0;i<n;i++)
            dp[0][i] = matrix[0][i];

        // iterate matrix from 1st row only
        for (int i =1;i< n;i++){
            for (int j =0;j< n;j++){
                if (j==0){
                    dp[i][j] = matrix[i][j]+ Math.min(dp[i-1][j],dp[i-1][j+1]);
                }else if (j == n-1){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else
                    dp[i][j] = matrix[i][j]+ Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]), dp[i-1][j+1]);
            }
        }

        //check in last row for minimum element
        for(int i = 0; i < matrix.length; i++){
            if(dp[matrix.length-1][i] < min)  min = dp[matrix.length-1][i];
        }
        return min;
    }
}
