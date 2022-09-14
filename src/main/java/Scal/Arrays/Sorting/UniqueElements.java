package Scal.Arrays.Sorting;

import java.util.Arrays;

/** Unique Elements
 * Problem Description
 * You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
 * Find the minimum number of steps.
 */
public class UniqueElements {

    private static int getcount(int []A){

        int count =0;
        Arrays.sort(A);
        for (int i=1;i<A.length;i++){
            if (A[i] <= A[i-1]) {
                int diff = A[i - 1] + 1 - A[i];
                A[i] = diff;
                count += diff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 1, 3};
        System.out.println(getcount(data));
    }

}
