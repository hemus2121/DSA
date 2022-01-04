package Scal.BinarySearch1.Assi;

/*Problem Description

Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
*/

public interface SortedInsertPosition {

    static int searchInsert (int []A, int B){
        int l =0;
        int r = A.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (A[mid]== B){
                return mid;
            }
            if (A[mid]< B) l= mid+1;
            else r= mid-1;
        }
        //last position indicates where element can be inserted after while loop breaks
        return l;
    }
    static void main(String[] args) {
      int [] A = {1,3,5,6};
        int B=4;
       System.out.println(searchInsert(A,B));

      //  int [] AA ={1};
       // int BB =1;
       // System.out.println(searchInsert(AA, BB));

    }
}
