package StriverSDE.Arrays;

/**  Search a 2D Matrix
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 *  Integers in each row are sorted from left to right.
 *  First integer of each row is greater than the last integer of the previous row.
 *  TC: log (n*m)
 *  SC: O(1)
 */
public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int low =0, high = (n*m)-1;

        while (low<= high){
            int mid = (low +high)/2;
            // trying to coordinates for 2D matris from 1 D matrix
            int row = mid /m, col = mid%m;

            if (matrix[row][col]== target ) return true;
            if (matrix [row][col] < target) low = mid+1;
            else high= mid-1;
        }
        return  false;
    }
    public static void main(String[] args) {
        int [][] data = {
                {1, 3, 5, 7},
                {10,11, 16,20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(data, 3));
    }
}
