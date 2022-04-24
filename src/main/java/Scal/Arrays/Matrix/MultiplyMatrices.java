package Scal.Arrays.Matrix;
/*
Matrix Multiplication

Problem Description
You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).
 */
public class MultiplyMatrices {
    static int [][] multiplyMatr(int [][]A, int [][]B){
        int aRows = A.length;
        int bRows = B.length;
        int bCols = B[0].length;

        int [][] result = new int[aRows][bCols];

        //3 loops computing row by row values
        for (int i =0;i< aRows;i++){
            for (int j =0;j<bCols;j++){
                int sum =0;
                for (int k=0;k< bRows;k++){
                    sum += A[i][k] * B[k][j];
                }
                result[i][j]= sum;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int [][] A ={
                {1,2},
                {3,4}
        };
        int [][] B= {
                {5,6},
                {7,8}
        };
        System.out.println((multiplyMatr(A,B)));
    }
}
