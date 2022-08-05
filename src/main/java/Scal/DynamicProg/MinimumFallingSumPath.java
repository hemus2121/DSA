package Scal.DynamicProg;

//https://leetcode.com/problems/minimum-falling-path-sum-ii/discuss/745208/Java-Simple-Solution

/** Minimum Falling Path Sum II
 * Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
 * A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.
 */
public class MinimumFallingSumPath {


    public static int minFallingPathSum(int[][] arr) {
        int rows =arr.length;
        int cols = arr[0].length;

        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){

                int min=Integer.MAX_VALUE;
                //iterate for column elements to get minimum value in previous row and column should not be same
                for(int k=0;k<cols;k++){

                    if(k != j && arr[i-1][k] < min){
                        min = arr[i-1][k];
                    }
                }
                //add previously obtained previous element to current element
                arr[i][j] += min;
            }
        }

        //iterate last row and get maximium element
        int[] lastRow = arr[arr.length-1];
        int min = Integer.MAX_VALUE;
        for(int i:lastRow){
            if(i< min){
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [][] data = {
                {1,2,3},
                { 4,5,6},
                { 7,8, 9}};
        System.out.println(minFallingPathSum(data));
    }
}
