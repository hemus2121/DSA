package Scal.Arrays;

/*
Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
 */
public class RainWaterTrapped {
    private static int getTrappedWater(int[] A) {
        //return computeWithExtraSpace(A);
        return  computeWithoutExtraSpace(A);
    }

    //Computation without using Extra Space
    private static int computeWithoutExtraSpace(int []A){
        int n = A.length;
        int left =0, right =n-1,res=0;
        int leftMax=0, rightMax=0;

        while (left < right){
            // When height of left side is lower, calculate height of water trapped in left bin else calculate for right bin
            if (A[left] <= A[right]){
                if (A[left] >= leftMax) leftMax = A[left];
                else res = leftMax-A[left];
                left++;
            }else {
                if (A[right] >= rightMax) rightMax = A[right];
                else res = rightMax-A[right];
                right--;
            }
        }
        return res;
    }

    //Computation using Extra Space
    private static int computeWithExtraSpace(int[] A) {
        int n = A.length;
        int[] left = new int[n];   // placeholder for left max values
        int[] right = new int[n];  // placeholder for right max values

        //compute left max array
        left[0] = A[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
        }

        //compute right max array
        right[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i]);
        }

        // compute total water
        int ans = 0;
        for (int i = 0; i < n; i++) {
            //choose minimum of left and right till now and reduce current height
            ans += Math.min(left[i], right[i]) - A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2};
        System.out.println(getTrappedWater(A));
    }
}
