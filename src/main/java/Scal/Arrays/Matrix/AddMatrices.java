package Scal.Arrays.Matrix;

/*  Add matrices

Problem Description
You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
 */
public class AddMatrices {

    static int [] [] addMatrices (int [][]A, int [][]B){
        int rows = A.length;
        int cols = A[0].length;

        //result matrix
        int [] [] result = new int [rows][cols];

        for (int i =0; i < rows;i++){
            for (int j =0; j< cols;j++){
                 result[i][j] = A[i][j] + B[i][j];
            }
        }
        return  result;
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
        System.out.println((addMatrices(A,B)));
    }
}
