package Scal.DynamicProg.TwoDArray;

public class UniquePathsInGridWithObs {
    private static int computePaths(int [][]A){
        int m = A.length;
        int n = A[0].length;

        //create a DP array
        int [] [] dp = new int [m][n];

        //return computeFromTopLeft(m,n, dp, A);
        return computePathFromBottomRight(m,n,dp,A);
        //return computePathUsingRecursion(0,0, m, n, dp, A);
    }

    //Solution 1 -  Bottom up - ITERATIVE - starting from LEFT MOST CORNER
    //https://leetcode.com/problems/unique-paths-ii/discuss/1778200/JAVA-or-DP
    static int computeFromTopLeft(int m, int n, int [][]dp,int [][]A){

        dp[0][0] = A[0][0] == 1 ? 0 : 1;
        //lets populate 1st column
        for (int i =1;i<m;i++){
            //if there is obstacle in 1st column
            if (A[i][0]!=1 ){
                dp[i][0] = dp[i-1][0];
            }
        }

        //lets poputate 1st row
        for (int j =1;j<n;j++){
            //if there is obstacle in 1st row
            if (A[0][j]!=1) {
                dp[0][j]=dp[0][j-1];
            }
        }

        //iterate for other cell values
        for (int i =1;i<m;i++){
            for (int j =1;j<n;j++){
                // 1 values denotes obstacle
                if (A[i][j]==1) dp[i][j]=0;
                else dp[i][j]= dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    //Solution 2- from BOTTOM RIGHT to TOP LEFT corner
   static int  computePathFromBottomRight(int m, int n, int [][]dp, int [][]A){
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                // obstacle is present
                if (A[i][j]==1) dp[i][j]=0;
                else if (i==n-1 && j==m-1){
                    dp[i][j]=1;
                }else if (i==m-1) {
                    dp[i][j] = dp[i][j + 1];
                }else if (j== n-1){
                    dp[i][j]= dp[i+1][j];
                }else {
                    dp [i][j]= dp [i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
   }


    //Solution 3 - RECURSION approach- Starting from LEFT MOST corner
    static int computePathUsingRecursion(int i, int j,int m, int n, int [][]dp, int [][]A){
        if (i==m-1  && j==n-1) return 1;
        if (i>=m  || j >=n) return 0;
        if (A[i][j]==1) return 0;

        if (dp[i][j]!=0) return dp[i][j];
        //compute
        dp[i][j]= computePathUsingRecursion(i+1,j, m,n,dp,A) + computePathUsingRecursion(i,j+1,m,n,dp,A);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int [][] data = new int [][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(computePaths(data));

    }
}
