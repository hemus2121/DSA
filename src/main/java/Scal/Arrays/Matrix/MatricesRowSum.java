package Scal.Arrays.Matrix;

import java.util.Arrays;
/*
Row Sum

Problem Description
You are given a 2D integer matrix A, return a 1D integer vector containing row-wise sums of original matrix.
*/

public class MatricesRowSum {
    static int [] getRowSum (int [] [] A){
        int rows = A.length;
        int cols = A[0].length;

        int [] resultArray = new int [ rows];
        int rowIndex=0;

        for (int i=0;i< rows;i++ ){
            int sum =0; // to store row sum values - init for each row beginning
            for (int j =0;j< cols;j++){
                sum += A[i][j];
            }
            resultArray[rowIndex++] = sum;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 2, 3, 4}
        };
        System.out.println(Arrays.toString(getRowSum(A)));
    }
}
