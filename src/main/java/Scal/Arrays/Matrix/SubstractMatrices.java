package Scal.Arrays.Matrix;

/* Matrix Subtraction
Problem Description
You are given two integer matrices A and B having same size(Both having same number of rows (N) and columns (M)). You have to subtract matrix A from B and return the resultant matrix. (i.e. return the matrix A - B).

If X and Y are two matrices of the same order (same dimensions). Then X - Y is a matrix of the same order as X and Y and its elements are obtained by subtracting the elements of Y from the corresponding elements of X.
Thus if Z = [z[i][j]] = X - Y, then [z[i][j]] = [x[i][j]] – [y[i][j]].
 */
public class SubstractMatrices {

    static int [][] subsMatrices(int [][]A, int [][]B){

        int rows = A.length;
        int cols = A[0].length;

        int [][] resultArray = new int [rows][cols];

        for (int i =0;i< rows;i++){
            for (int j =0;j< cols;j++){
                resultArray[i][j] = A[i][j] - B[i][j];
            }
        }
        return resultArray;
    }
    public static void main(String[] args) {
        int [][] A ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int [][] B= {
                {9,8,7},
                {6,5,4},
                {3,2,1}
        };
        System.out.println((subsMatrices(A,B)));

    }
}
