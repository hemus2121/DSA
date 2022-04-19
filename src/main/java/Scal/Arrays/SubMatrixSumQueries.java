package Scal.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

    Rows are numbered from top to bottom and columns are numbered from left to right.
    Sum may be large so return the answer mod 109 + 7.
 */
public class SubMatrixSumQueries {
    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        int mod = (int)Math.pow(10,9) + 7;

        int row = A.length;
        int col = A[0].length;

        int [] res = new int [B.length];

        //lets build PF Array both row wise and column wise
        int [][] pfArr = new int [row][col];
        pfArr[0][0]= A[0][0];

        // 1st row of PF Array
        for(int i=1;i<col;i++){
            pfArr[0][i] = (A[0][i]+pfArr[0][i-1])%mod;
        }

        // 1st column of PF array
        for (int i =1;i<row;i++){
            pfArr[i][0]= (A[i][0]+pfArr[i-1][0])%mod;
        }

        // //final prefix array of both row and column
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                pfArr[i][j]=  ( (pfArr[i][j-1])+((pfArr[i-1][j]-pfArr[i-1][j-1])+mod)%mod+(A[i][j]))%mod;
            }
        }

        //now iterate over input query elements gets values to deduce from PF matrix
        for (int i=0;i< B.length;i++){
            int rs = B[i]-1;
            int cs = C[i]-1;

            int re = D[i]-1;
            int ce = E[i]-1;


            int top = (rs-1 >=0) ? pfArr[rs-1][ce]:0;
            int left = (cs-1 >=0)? pfArr[re][cs-1]:0;
            //common element of top row and left colmn
            int common = (rs-1 >=0 && cs-1 >=0)? pfArr[rs-1][cs-1]:0;

            long sum = pfArr[re][ce]-top-left+common;
            res[i]= (int)((sum%mod+mod)%mod);
        }
        return res;
    }


    public static void main(String[] args) {
        int [] [] A ={
                {1, 2, 3},
                {4,5,6},
                {7,8,9}
        };
        int [] B = {1,2};
        int [] C = {1,2};
        int [] D = {2,3};
        int [] E = {2,3};
        System.out.println(Arrays.toString(solve(A,B,C,D,E)));
    }
}
