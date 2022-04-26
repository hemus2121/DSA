package Scal.Arrays.Matrix;

/* Matrix Transpose

Problem Description

You are given a matrix A, you have to return another matrix which is the transpose of A.
NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row
 */
import java.util.Arrays;

public class MatrixTranspose {
    static int [][] getTranspose(int [][] A){
        //since its N*M  matrix we are doing traversal otherwise we can do only 1st top right triangle rotation
        int rows = A.length;
        int cols = A[0].length;

        int [][] transposedMatrix = new int [cols][rows];

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = A[i][j];
            }
        }

        return transposedMatrix;
    }
    public static void main(String[] args) {
        int [][] A= {
            {1,2},
            {1,2},
            {1,2}
        };
        System.out.println(Arrays.toString(getTranspose(A)));
    }
}
