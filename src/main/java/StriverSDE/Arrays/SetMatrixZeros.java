package StriverSDE.Arrays;

/** Set Matrix Zeros- https://leetcode.com/problems/set-matrix-zeroes/
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 */
public class SetMatrixZeros {

    // Time Complexity: O(N*M + N*M)
    // Space Complexity: O(N)
    private static void setZeroesSemiOptimal(int [][] matrix){
        //lets have 2 extra arrays to denote position of Zeros in input matrix - EXTRA SPACE
        int [] dummy1 = new int [matrix.length];
        int [] dummy2 = new int [matrix.length];

        //Iterate input matrix
        for (int i =0;i<matrix.length;i++){
            for (int j =0;j< matrix[0].length;j++){
                if (matrix[i][i]==1){
                    dummy1[i]=0;
                    dummy2[j]=0;
                }
            }
        }
        //Now iterate matrix and check dummy values and set original matrix
        for (int i =0;i< matrix.length;i++){
            for (int j =0;j< matrix[0].length;j++){
                if (dummy1[i] ==0 || dummy2[j]==0){
                    matrix[i][j]=0;
                }
            }
        }
    }


    // Time Complexity:O(2*(N*M))
    // Space Complexity: O(1)
    private static void setZeroesOptimal(int[][] matrix) {

        int colIndex=1, row = matrix.length, cols= matrix[0].length;

        //Iterate over given matrix and mark 1st row and column as Zero if element is zero
        for (int i=0;i< row;i++){
            if (matrix[i][0]==0) colIndex =0;  // but for 1st column if any Zero is present  update column Index value to 0
            for (int j =1;j< cols;j++){
                if ( matrix[i][j]==0){
                    matrix [0][j] = matrix[i][0]=0;// setting both respective cols and row values as zero
                }
            }
        }

        //Iterate from backside
        for (int i = row-1;i >=0;i--){
            for (int j = cols -1; j >=1;j--){
                if (matrix[0][j]==0 || matrix[i][0]==0){ // if any of col or row cell  value is zero set cell value as zero
                    matrix[i][j]=0;
                }
            }
            if (colIndex==0) matrix[i][0]=0;// if any colIndex is zero set matrix column value  to be zero
        }
    }

    public static void main(String[] args) {
            int [][] matrix ={
            {1,1,1}, {1,0,1}, {1,1,1} };
            setZeroesSemiOptimal(matrix);
            setZeroesOptimal(matrix);
    }
}
