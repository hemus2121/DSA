package Scal.Arrays.Matrix;
/* Anti Diagonal

Problem Description
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
Input 1:
1 2 3
4 5 6
7 8 9

Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0

Problem Constraints
1<= N <= 1000
1<= A[i][j] <= 1e9

 */
public class AntiDiagonal {
    static  int [] [] antidiagonal(int [][]A){

        int N= A.length;
        int newRowSize = N+N-1;
        int [][] antiDiagonalArray = new int [newRowSize][N];

        int x=0;
        //for all the iterations starting form 1st row
        for (int col =0; col< N;col++){
            int start=0, end=col, y=0;
            while( start<N && end>=0){
                antiDiagonalArray[x][y++]=A[start++][end--];
            }
            x++;
        }

        //for (M-1) column case
        x=0;
        for (int row=1; row< N; row++){
             int start =row, end=N-1, y=0;
            while( start<N && end>=0){
                antiDiagonalArray[x][y++]=A[start++][end--];
            }
            x++;
        }
        return  antiDiagonalArray;
    }
    public static void main(String[] args) {
        int [][] data = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(antidiagonal( data));

    }
}
