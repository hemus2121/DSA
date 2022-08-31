package Scal.Arrays.DSAArrays;

/* Maximum NonNegative Sub Array
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.
NOTE:
    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.
 */

import java.util.Arrays;

public class MaximumNonNegativeSubArray {

    static int []  getSubArray(int [] A){

        // initialize final start index, end index and sum
        int answer_start_index = 0;
        int answer_end_index = 0;
        // take long as sum can overflow
        long sum = 0;

        // initialize temp start index, end index and sum
        int temp_start = 0;
        int temp_end = 0;
        long temp_sum = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] < 0) {
                // if A[i] is -ve, reset the sum and temp indexes
                temp_sum = 0;
                temp_start = i + 1;
                temp_end = i + 1;
            } else {
                // if A[i] is +ve, include this in current temp sum
                temp_sum = temp_sum + (long) A[i];
                // increase end index
                temp_end = i;

                if (temp_sum > sum
                        || (temp_sum == sum && temp_end - temp_start > answer_end_index - answer_start_index)) {
                    // if we get the better answer, update the answer variables
                    answer_start_index = temp_start;
                    answer_end_index = temp_end;
                    sum = temp_sum;
                }
            }
        }

        // extract the subarray from indexes and return final array
        int[] answer = new int[answer_end_index - answer_start_index + 1];
        int j = 0;
        for (int i = answer_start_index; i <= answer_end_index; i++) {
            answer[j++] = A[i];
        }

        // return empty if first element in answer array is -ve
        if (answer[0] < 0) {
            answer = new int[] {};
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] A = {1, 2, 5, -7, 2, 3};
        System.out.println(Arrays.toString(getSubArray(A)));
    }
}
