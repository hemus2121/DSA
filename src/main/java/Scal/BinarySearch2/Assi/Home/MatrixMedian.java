package Scal.BinarySearch2.Assi.Home;

/*
Problem Description

Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of the matrix A.

NOTE: No extra memory is allowed.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 */
public class MatrixMedian {

    private static int getMedian(int[][]A){

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int rowcount = A.length;
        int colcount = A[0].length;
        // median value is row*column/2+1
        int desiredValue = 1 + (rowcount * colcount) / 2;
        int ans = 0;

        // compute max min values from since array is sorted out- row wise count
        for (int i = 0; i < rowcount; i++) {
        //min value is 1st  column only
            if (A[i][0] < low) {
                low = A[i][0];
            }
            //max value is in last column only
            if (A[i][colcount - 1] > high) {
                high = A[i][colcount - 1];
            }
        }

        //binary search in each row
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // get count of elements less than mid in all rows
            int count = 0;
            for (int i = 0; i < rowcount; i++) {
                count += getSmallestCount(A[i], mid);
            }

            if (count < desiredValue) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    //find in each row
    public static int getSmallestCount(int[] row, int mid) {
        int low = 0, count = 0;
        int high = row.length - 1;
        while (low <= high) {
            int midd = low + (high - low) / 2;
            if (row[midd] <= mid) {
                low = midd + 1;
                count = midd + 1;
            } else {
                high = midd - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [][] A = {
                {1, 3, 5},
                {2,6,9},
                {3,6,9}
        };
        System.out.println(getMedian(A));
    }
}
