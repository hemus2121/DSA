package Scal.Arrays.Matrix;

/*
Problem Description
You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix A with an integer B.
 */
public class MatrixScalarProduct {
    static int[][] getScalarProduct(int[][] A, int B) {
        for (int i =0; i< A.length ; i++){
            for (int j =0; j< A[0].length; j++){
                A[i][j] *= B;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println((getScalarProduct(A, 2)));
    }
}
