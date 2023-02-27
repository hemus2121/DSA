package Scal.Hashing;

import java.util.*;
/*Problem Description
Given 2 arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2-D Cartesian plane.
Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
*/
public class CountOfRectangles {
    private static int getRectanglesCount(int [] A, int []B){
        // store the elements in string format into Set
        Set<String> coordinateSet = new HashSet();
        for (int i=0;i<A.length;i++){
            coordinateSet.add(""+A[i]+B[i]);
        }

        //now iterate over elements to check for other coordinates is present
        int rectCount=0;
        for (int i =0;i<A.length;i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] != A[j] && B[i] != B[j]) {
                    if (coordinateSet.contains("" + A[i] + B[j]) || coordinateSet.contains("" + A[j] + B[i])) {
                        rectCount++;
                    }
                }
            }
        }
       // System.out.println(rectCount);
        //to remove duplicate counts dividing by 2
        return rectCount>>1;

    }
    public static void main(String[] args) {
        int [] A = { 1,1,2,2};
        int [] B ={1,2,1, 2};
        System.out.println(getRectanglesCount(A, B));

        int [] AA= {1, 1, 2, 2, 3, 3};
        int [] BB= {1, 2, 1, 2, 1, 2};
        System.out.println(getRectanglesCount(AA,BB));
    }

}
