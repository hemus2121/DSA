package Scal.DynamicProg.TwoDArray;


import java.util.Arrays;
//https://leetcode.com/problems/dungeon-game/discuss/1611492/Java-O(M*N)O(1)
//https://leetcode.com/problems/dungeon-game/discuss/1641955/Java-%2B-DP-%2B-Intuition-%2B-Code-with-comments
public class DungeonPrincess {
    static int [][] dp ;
    private static  int minimum(int [][] A){
        int m = A.length-1;
        int n = A[0].length-1;
        dp = new int [m+1][n+1];
        return solveRecursive (0,0,m,n,A);
    }

    //RECURSIVE APPROACH
    static  int  solveRecursive(int currentrow, int currentcol, int m, int n,int [][] A){
        //BASE case
        if (currentrow > m || currentcol >n) return Integer.MAX_VALUE;

        //BASE case
        if (currentrow ==m && currentcol ==n){
           return Math.max(1, 1-A[currentrow][currentcol]);
        }
        // check in existing array if values is present return it
        if (dp[currentrow][currentcol]!=0) return dp[currentrow][currentcol];


        int c1 = solveRecursive(currentrow+1,currentcol, m,n, A);
        int c2 = solveRecursive(currentrow, currentcol+1, m,n, A);
        int initial = Math.min(c1,c2)- A[currentrow][currentcol];
        dp[currentrow][currentcol]= Math.max(1,initial);
        return dp[currentrow][currentcol];
    }


    //ITERATIVE WAY - as explained by mohit- and explained in video
    static public int computeMin(int [][]A){
        int rows = A.length;
        int cols = A[0].length;

        int[][] dpArray = new int[rows + 1][cols + 1];
        for (int[] m : dpArray) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        // the positions behind the princess.
        dpArray[rows][cols - 1] = 1;
        dpArray[rows - 1][cols] = 1;

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                dpArray[i][j] = Math.max(1, Math.min(dpArray[i + 1][j], dpArray[i][j + 1]) - A[i][j]);
            }
        }
        return dpArray[0][0];
    }

    public static void main(String[] args) {
        int [] [] data = new int [] [] {
                {-2, -3, 3},
                {-5,-10,1},
                {10, 30,-5}

        };
        System.out.println(minimum(data));
        System.out.println(computeMin(data));
    }
}
