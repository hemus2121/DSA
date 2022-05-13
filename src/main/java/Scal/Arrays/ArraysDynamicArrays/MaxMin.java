package Scal.Arrays.ArraysDynamicArrays;
/* Max Min
Problem Description
Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
NOTE: You should make minimum number of comparisons.
 */
public class MaxMin {
    private static int getMaxMinSum(int [] A){
        int max = A[0];
        int min = A[0];

        //iterate array to compute min and max element on the fly
        for (int a : A){
            if (a > max){
                max = a;
            }
            if (a < min){
                min = a;
            }
        }
        return max + min;
    }

    public static void main(String[] args) {
        int [] data = {-2, 1, -4, 5, 3};
        System.out.println(getMaxMinSum(data)); //expected - 1
    }
}
