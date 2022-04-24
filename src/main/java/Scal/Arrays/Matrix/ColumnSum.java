package Scal.Arrays.Matrix;

import java.util.Arrays;

/*
Column Sum

Problem Description
You are given a 2D integer matrix A, return a 1D integer vector containing column-wise sums of original matrix.
 */
public class ColumnSum {

    private static int [] computeColumnSum(int [][]A){

        int rows = A.length; //rows
        int columns = A[0].length; //columns

        //result array size == column count
        int [] result = new int[columns];
        int resultIndex=0;

        for(int j=0;j< columns;j++){
            int colSum=0;
            for (int i =0;i< rows;i++){
                colSum += A[i][j];
            }
            result[resultIndex++] = colSum;
        }
        return  result;
    }
    public static void main(String[] args) {
        int [] [] A ={
                {1,2,3,4},
                {5,6,7,8},
                {9,2,3,4}
        };
        System.out.println(Arrays.toString(computeColumnSum(A)));
    }
}
