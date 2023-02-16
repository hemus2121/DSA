package Scal.Arrays.ArraysDynamicArrays;

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */
public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prod = 1;
        //traverse from left
        for (int i : nums) {
            prod = prod * i;
            max = Math.max(max, prod);
            if (prod ==0) prod =1;
        }

        //traverse from right
        prod =1;
        for (int i = nums.length-1;i>=0;i--){
            prod = prod * nums[i];
            max = Math.max(max, prod);
            if (prod==0) prod =1;
        }
        return max;
    }

    public static void main(String[] args) {
        int [] data = {2,3,-2,4};
        System.out.println(maxProduct(data));

    }
}

