package StriverSDE.Arrays;

/** Rotate Image by 90 degree
 * Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
 */
public class RotateMatrix {
    private static void rotateMatrixInPlace(int [][] A){
        int n = A.length;
        for (int i =0;i<n/2;i++ ) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = A[i][j];
                A[i][j]=A[n-1-j][i];
                A[n-1-j][i] = A[ n-1-i][n-1-j];
                A[n-1-i][n-1-j]= A[j][n-1-i];
                A[j][n-1-i]= temp;
                //int temp = A[i][j];
                //                A[i][j]= A[n-1-j][i];
                //                A[n-1-j][i]= A[ n-1-i][n-1-j];
                //                A[n-1-i] [n-1-j] = A [j][n-1-i];
                //                A[j][n-1-i] =temp;
            }
        }
    }
    public static void main(String[] args) {
        int [][] data = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateMatrixInPlace(data);
        System.out.println(data);
    }
}
