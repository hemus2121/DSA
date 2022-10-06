package StriverSDE.Arrays;

import java.util.Arrays;

/** Unique Paths
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class GridUniquePaths {

    static  int countWayUtil(int i, int j, int [][] dp){
        //base case
        if (i==0 || j ==0) return 1;
        if (i<0 || j <0) return 0;
        //already present in dp table
        if (dp[i][j] != -1) return dp [i][j];
        int up  = countWayUtil(i-1,j, dp);
        int left = countWayUtil(i,j-1, dp);
        return dp[i][j] = up + left;
    }
    //solving using DP
    private static int gridUniquePathsUsingDP(int m, int n){
        int [][] dp = new int [m][n];
        for (int [] row : dp){
            Arrays.fill(row, -1);
        }
        return countWayUtil(m-1, n-1, dp);
    }

    //solution using Combinatorics using NCr formulas
    //https://leetcode.com/problems/unique-paths/discuss/871688/Detail-explanation-%3A-Using-combination-0-ms-and-100-faster
    private static  int gridUniquePathsUsingCombi(int m , int n){
        int N= m+n-2;
        int r = m-1;
        double res = 1;
        for (int i=1;i<= r;i++){
            res = res * (N-r+i)/i;
        }
        return (int)res;
    }
    public static void main(String[] args) {
        int m =3, n=7;
        System.out.println(gridUniquePathsUsingDP(m,n));
        System.out.println(gridUniquePathsUsingCombi(m, n));
    }
}
