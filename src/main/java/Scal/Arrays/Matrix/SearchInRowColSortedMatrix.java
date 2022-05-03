package Scal.Arrays.Matrix;

/* Search in a row wise and column wise sorted matrix

Problem Description
Given a matrix of integers A of size N x M and an integer B.

In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
If A[i][j] = B then return (i * 1009 + j)
If B is not present return -1.

Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.

Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
-100000 <= B <= 100000

 */
public class SearchInRowColSortedMatrix {
    private static int getLocation(int [][] A, int B){
        int rows = A.length;
        int cols = A[0].length;

        for (int i =0;i< rows;i++){
            for (int j =0;j< cols; j++){
                if (A[i][j]== B){
                    //since index starting from 0 but expected results index starts from 1, incrementing i and j th index before returning
                    return ((i+1)*1009+ (j+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Expected is --> 1011
        int [][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(getLocation(data, 2));
    }
}
