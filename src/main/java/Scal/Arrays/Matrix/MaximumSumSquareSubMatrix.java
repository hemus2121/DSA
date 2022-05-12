package Scal.Arrays.Matrix;
/*
Maximum Sum Square SubMatrix
Problem Description
Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.
Problem Constraints
1 <= N <= 10^3.
1 <= B <= N
-10^2 <= A[i][j] <= 10^2.
Input Format
First argument is an 2D integer matrix A.
Second argument is an integer B.
Output Format
Return a single integer denoting the maximum sum of submatrix of size B x B.
Example Input
Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:
 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2
Example Output
Output 1:
 48
Output 2:
 8
Example Explanation
Explanation 1:
    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
Explanation 2:
 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8

 */
public class MaximumSumSquareSubMatrix {

    private static int maximumSumSquareSubMatrix(int [][]A, int B){
        int row = A.length;
        int col = A[0].length;
        int ans = Integer.MIN_VALUE;

        //Init PF array
        int [][] pfArrColumnWise = new int[row][col];

        // generate PF array column wise
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    pfArrColumnWise[j][i] = A[j][i];
                } else {
                    pfArrColumnWise[j][i] = pfArrColumnWise[j - 1][i] + A[j][i];
                }
            }
        }

        //iterate input matrix
        //int topRow, bottomRow;
        for (int topRow = 0, bottomRow = topRow + B - 1; topRow <= row - B ; topRow++, bottomRow++) {

            for (int j = 0; j <= col - B; j++) {

                // Apply Kadene's algorithm for each submatrix of size BxB
                int sum=0 ;
                for (int k = 0; k < B; k++) {
                    sum += pfArrColumnWise[bottomRow][j + k];

                    if (topRow > 0) {
                        sum -= pfArrColumnWise[topRow - 1][j + k];
                    }
                }
                ans = Math.max(ans, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
        }
        return  ans;
    }

    private static int maximumSumSquareSubMatrixUsingDP(int [][]A, int B){
        int row = A.length;
        int col = A[0].length;
        int [][] pfArray = new int [row+1][col+1];
        for (int i=1;i< pfArray.length;i++){
            for (int j=1;j< pfArray[0].length;j++){
                pfArray[i][j] = A[i-1][j-1]+ pfArray[i-1][j]+ pfArray[i][j-1]- pfArray[i-1][j-1];
            }
        }
       //compute using pfarray we have
        int maxSum = Integer.MIN_VALUE;
        for (int i =1;i< pfArray.length;i++){
            int sum=Integer.MIN_VALUE;
            for (int j =1;j< pfArray[0].length;j++){
                //condition check
                if(i -B>=0 && j-B>=0){
                    sum = pfArray [i][j]- pfArray[i-B][j]-pfArray[i][j-B]+ pfArray[i-B][j-B];
                    maxSum = Math.max(sum,maxSum);
                }
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int [][] data = {
                {8,6,7},
                {4,4,4},
                {5,5,5}
        };
        System.out.println(maximumSumSquareSubMatrix(data,3));
        System.out.println(maximumSumSquareSubMatrixUsingDP(data,3));
    }
}
