package Scal.Arrays.Matrix;
/* Row to Column Zero

Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
Specifically, make entire ith row and jth column zero.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RowToColumnZero {
    private static int [][] rowToColumnZero(int [][] A){
        //Store the index of rows and columns which contains zeros
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        int [][] resultArray =  new int [A.length][A[0].length];

        for (int i =0;i <A.length;i++){
            for (int j =0;j< A[0].length;j++){
                if (A[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        //building result Array checking rows and cols in hashsets
        for (int i =0;i< A.length;i++){
                for (int j =0;j < A[0].length;j++){
                    if ( rowSet.contains(i) ||colSet.contains(j)){
                        A[i][j] = 0;
                    }
            }
        }

        return A;
    }
    public static void main(String[] args) {
        int [] [] A= { { 1,2,3,4},
                {5,6,7,0},
                {9,2,0,4}
        };
        System.out.println(Arrays.toString( rowToColumnZero(A))); //expected [1,2,0,0][0,0,0,0][0,0,0,0]
    }
}
