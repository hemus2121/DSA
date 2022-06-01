package LeetCode.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeSet;

/*
Find maximum sum of triplets in an array such than i < j < k and a[i] < a[j] < a[k]
Given an array of positive integers of size n. Find the maximum sum of triplet( ai + aj + ak ) such that 0 <= i < j < k < n and ai < aj < ak.

Input: a[] = 2 5 3 1 4 9
Output: 16
 */
public class MaxTriplets {
    private static int getMaximum(int [] arr){
        int n = arr.length;

        // suffix array
        int [] suffArray = new int [ n+1];
        suffArray [n] =0; //set the last element

        //compute suffix array
        for (int i = n-1;i>=0;i--){
            suffArray [i] = Math.max(arr[i], suffArray[i+1]);
        }
        System.out.println(Arrays.toString(suffArray));

        TreeSet <Integer> treeSet = new TreeSet();
        treeSet.add(Integer.MIN_VALUE);
        int ans =0;

        //iterate array from starting
        for (int i =0;i<n;i++){
            if (suffArray[i+1] > arr[i]){
                ans = Math.max(ans, treeSet.lower(arr[i]) + arr[i] + suffArray[i + 1]);

                treeSet.add(arr[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] data = { 2, 5, 3, 1, 4, 9 };
        System.out.println(getMaximum(data));

    }
}
