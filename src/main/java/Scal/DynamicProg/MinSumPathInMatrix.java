package Scal.DynamicProg;
/*
Problem Description
Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.
 */
import java.util.Arrays;
public class MinSumPathInMatrix {

    private static  int computeMinSumPath(int [][] A){
        //lets us create a new dp matrix
        int m = A.length;
        int n = A[0].length;

        //create a dp matrix for storing values
        int [] [] dp = new int [m][n];
        dp[0][0]= A[0][0];

        //return computePathFromTopLeft(m, n, dp, A);
       return computePathFromBottomRight(m,n, dp,A);

       // for (int i = 0; i < m; i++)
       //     Arrays.fill(dp[i], Integer.MAX_VALUE);
       // return computePathRecursive(m-1,n-1, dp,A);
    }

    //Solution 1 - from TOP LEFT corner to BOTTOM RIGHT corner
    static int computePathFromTopLeft(int m, int n, int [][] dp, int [][] A){
        dp[0][0]= A[0][0];

        // compute 1st col values since only DOWN is allowed
        for (int i =1;i<m;i++){
            dp[i][0]= dp[i-1][0]+ A[i][0];
        }

        //compute 1st row values since only RIGHT is allowed
        for (int j =1;j<n;j++){
            dp[0][j]= dp[0][j-1]+ A[0][j];
        }

        //lets iterate from 1,1 to m,n
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]= Math.min(dp[i-1][j],dp[i][j-1])+A[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    //Solution 2- from BOTTOM RIGHT to TOP LEFT corner
    static int  computePathFromBottomRight(int m, int n, int [][]dp, int [][]A){

        for (int i =m-1;i>=0;i--){
            for (int j = n-1;j>=0;j--){

                if (i==m-1 && j ==n-1){ // last cell values copy as it is
                    dp[i][j]= A[i][j];
                } else if (i==m-1){ // if we are at last row , therefore we go in right as we have no other option
                    dp[i][j]= dp[i][j+1]+ A[i][j];
                } else if (j ==n-1){ // if we are at last column, so we go down
                    dp [i][j] = dp[i+1][j] + A[i][j];
                } else { //else we are at other places , so we add curr value and min from right and down
                    dp[i][j]= Math.min(dp[i+1][j], dp[i][j+1])+ A[i][j];
                }
            }
        }
        return dp[0][0];
    }

    //Solution 3- TOP DOWN -Recursive solution
    static int computePathRecursive(int m, int n, int [][]dp, int[][]A){
        if (m<0 || n <0) return Integer.MAX_VALUE;
        if (dp[m][n]!=Integer.MAX_VALUE) return  dp[m][n];
        //compute
        int res = Math.min(computePathRecursive(m-1,n, dp,A), computePathRecursive(m,n-1,dp,A));
        dp[m][n] = res+ A[m][n];
        return dp[m][n];
    }

        public static void main(String[] args) {
        int [] [] data = new int [] [] {
                {1,3,2},
                {4,3,1},
                {5,6,1}
        };
        System.out.println(computeMinSumPath(data));
    }
}
