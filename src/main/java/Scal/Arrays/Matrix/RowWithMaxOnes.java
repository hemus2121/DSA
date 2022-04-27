package Scal.Arrays.Matrix;

/* Row with maximum number of ones
Problem Description
Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

NOTE:
    If two rows have the maximum number of 1 then return the row which has a lower index.
    Rows are numbered from top to bottom and columns are numbered from left to right.
    Assume 0-based indexing. Assume each row to be sorted by values.
    Expected time complexity is O(rows).
 */
public class RowWithMaxOnes {

    static int getRowWithMaxOnce(int [][]A){
        int rowValue=0;
        int n = A.length;
        int rowIndex=0;
        int colIndex = A[0].length-1;

        while (rowIndex < n && colIndex >=0){
            if (A[rowIndex][colIndex]==1){
                rowValue = rowIndex;
                colIndex--; // found so skip current col
            }else{
                rowIndex++; // not found in current row so try with next row
            }
        }
        return  rowValue;
    }

    public static void main(String[] args) {
        int [][]  data={
            {0, 1, 1},
            {1, 1, 1},
            {0, 1, 1}
            };
        System.out.println(getRowWithMaxOnce(data));
        }
}