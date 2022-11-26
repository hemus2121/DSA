package Visa.BinarySearch;

/** Search in 2D matrix
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==1) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int low=0, high = (row*col)-1;

        //normal binary search
        while (low <= high) {
            int mid = (low + high) / 2;

            //get 2D matrix coordinates
            int rows = mid / col, cols = mid % col;

            if (matrix[rows][cols] == target) return true;
            if (matrix[rows][cols] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
