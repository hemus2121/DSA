package LeetCode.Arrays;

import java.util.Arrays;
/*
RotateArray - Right - https://leetcode.com/problems/rotate-array/
Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

public class RotateArray {
    private static int [] rotateArray(int [] nums, int k ){

        int n = nums.length;
        k = k % n;
        rotate(nums, 0, n-1);
        rotate(nums,0, k-1);
        rotate(nums,k, n-1);
        return  nums;
    }

    static void rotate(int [] nums, int start, int end){
        while (start < end){
            int temp = nums [start];
            nums [start] = nums[end];
            nums [end] = temp;
            start++;
            end --;
        }
    }

    public static void main(String[] args) {
        int [] data = { 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(data,3)));

        int [] data1 = { -1,-100,3,99};
        System.out.println(Arrays.toString(rotateArray(data1,2)));
    }
}
