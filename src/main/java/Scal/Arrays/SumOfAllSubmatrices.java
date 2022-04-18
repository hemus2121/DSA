package Scal.Arrays;

/*  Sum of all Submatrices

Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
 */
public class SumOfAllSubmatrices {

    private static int sumOfAllSubMatrices( int [][]A){
        int row = A.length;
        int col = A[0].length;
        int ans =0;

        //using CONTRIBUTION technique  of each element in Matrix
        for (int i = 0;i<= row-1;i++){
            for (int j =0; j<= col -1;j++){
                int topleft = (i+1) * (j+1);
                int bottomright = (row-i ) * (col -j);
                ans += A[i][j] * topleft * bottomright;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        int [] [] A = {
                {1, 1},
                {1, 1}
        };
        System.out.println(sumOfAllSubMatrices(A));
    }
}
