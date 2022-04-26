package Scal.Arrays.Matrix;
/*
Minor Diagonal Sum

Problem Description
You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).
 */
public class MinorDiagonalSum {
    private static int getMinorDiagonalSum(int [][]A){
        int n = A.length;
        int sum =0;
        //Since its square matrix --  diagonal coordinates are equal
        for (int i =0;i<n;i++){
            int j = n-1-i;
            sum += A[i][j];
        }
        return  sum;
    }
    public static void main(String[] args) {
        int [][] A={
                {1, -2, -3},
                {-4, 5, 6},
                {-7, -8 , 9}
        };
        System.out.println(getMinorDiagonalSum(A));
    }
}
