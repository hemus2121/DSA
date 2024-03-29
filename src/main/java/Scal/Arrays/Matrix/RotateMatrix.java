package Scal.Arrays.Matrix;

/*
Rotate Matrix

Problem Description

You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place
Note: If you end up using an additional array, you will only receive partial score.
 */
public class RotateMatrix {

    //USING INDEX manipulation - BEST APPROACH (i-j) -- (j, n-1-i)  - - (n-1-i, n-1-j) -- (n-i-j,i)
    //                                          |______________________________________________|

    //   i , j  // j becomes row for next and column is computed as (n-1) of previous row value
    //   j,  n-1-i (n-1-i)
    //   n-1-i, n-1-j (n-1-j)
    //   n-1-j , i --> [n-1-(n-1-i)--> n -1 -n +1 +i) --->i)
    private static void rotateMatrixInPlace(int [][]A){
        int n = A.length;
        for(int i = 0; i<n/2; i++){
            //for (int j =i;j< i;j++){
            for(int j = i; j<n-i-1; j++){
                int temp = A[i][j];
                A[i][j]= A[n-1-j][i];
                A[n-1-j][i]= A[ n-1-i][n-1-j];
                A[n-1-i] [n-1-j] = A [j][n-1-i];
                A[j][n-1-i] =temp;
            }
        }
        System.out.println(A);
    }

    //Using method of Transpose and swapping row element - swap either upper triangle or lower triangle of the matrix based ont main Diagonal
    private static void rotateusingTrasnposeAndRowReversal(int [][]A){
        //step1. Transpose of a matrix - lower triangle matrix

        // SWAP LOWER TRIANGLE MATRIX
//        for (int i =1;i< A.length;i++){
//            for (int j = 0;j <i;j++){
//                A[j][i] = A[j][i] ^ A[i][j];
//                A[i][j] = A[j][i] ^ A[i][j];
//                A[j][i] = A[j][i] ^ A[i][j];
//            }
//        }

        // SWAP UPPER TRIANGLE MATRIX
        for (int i =0;i< A.length;i++){
            for (int j = i+1;j <A.length;j++){
                A[i][j] = A[i][j] ^ A[j][i];
                A[j][i] = A[i][j] ^ A[j][i];
                A[i][j] = A[i][j] ^ A[j][i];
            }
        }


        //Step 2 : swap row elements
        for (int i =0;i< A.length;i++){
            int start =0;
            int end = A.length-1;
            while (start < end){
                A[i][start] = A[i][end] ^ A[i][start];
                A[i] [end] = A[i][end] ^ A[i][start];
                A[i] [start] = A[i][end] ^ A[i] [start];
                start++;
                end --;
            }
        }
        System.out.println(A);

    }
    public static void main(String[] args) {
        int [][] data = {
                {1, 2},
                {3, 4 }
        };
        rotateMatrixInPlace(data);
        rotateusingTrasnposeAndRowReversal(data);
    }
}