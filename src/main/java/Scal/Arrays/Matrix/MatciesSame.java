package Scal.Arrays.Matrix;

import java.util.Arrays;

/*
Problem Description

You are given two matrices A & B of equal dimensions and you have to check whether two matrices are equal or not.
NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.

 */
public class MatciesSame {
    static int checkMatricesSame(int [][]A, int [][]B){
        //Iterate and check equality of matrices
        for (int i=0;i< A.length;i++){
            for (int j =0;j< A[0].length ;j++){
                if ( A[i][j]!= B[i][j]) return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        int [][] A= {
                {1,2},
                {1,2},
                {1,2}
        };

        System.out.println((checkMatricesSame(A,A)));
    }
}