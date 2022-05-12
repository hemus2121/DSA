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

        //variable to hold final index and sum
        int final_start=0;
        int final_end=0;
        long final_sum =0;

        //variable to hold intermediate index and sum
        int temp_start=0;
        int temp_end=0;
        long temp_sum=0;

        //Lets iterate over input array elements
        for (int i =0;i< A.length;i++){

            //case where read negative input element- reset sum and update indexes
            if (A[i] <0){
                temp_sum=0;
                temp_start = i+1;
                temp_end = i+1;
            }else {
                temp_sum += (long) A[i];
                temp_end =i;

                //update final variables based on cond
                // 1. temp_sum > final_sum
                // 2. temp_sum == final_sum then get maximum index values
                if (temp_sum > final_sum ||
                   temp_sum == final_sum && final_end- final_start < temp_end-temp_start){
                     final_sum = temp_sum;
                     final_end = temp_end;
                     final_start = temp_start;
                }
            }
        }

        //Generate result array elements based on final index
        int j =0;
        int [] result = new int[final_end-final_start+1];
        for (int i = final_start ;i<= final_end;i++){
             result[j++] = A[i];
        }

        //if result start with negative value return new empty array
        return (result[0]<0) ? new int [] {}: result;
    }

    public static void main(String[] args) {
        int [] A = {1, 2, 5, -7, 2, 3};
        System.out.println(Arrays.toString(getSubArray(A)));
    }
}
