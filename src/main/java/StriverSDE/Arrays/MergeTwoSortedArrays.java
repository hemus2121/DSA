package StriverSDE.Arrays;

/**
 * Merge 2 Sorted Arrays
 * https://leetcode.com/problems/merge-sorted-array/discuss/2120234/Visual-Explanation-or-O(1)-Space-JAVA
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * TC: O(n+m)
 * SC: O(1)
 */
public class MergeTwoSortedArrays {

    public static void mergeUsingApproach1(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2])
                nums1[index] = nums1[p1--];
            else nums1[index] = nums2[p2--];
            index--;
        }
        while (p1 >= 0) nums1[index--] = nums1[p1--];
        while (p2 >= 0) nums1[index--] = nums2[p2--];
    }

    public static void mergeUsingApproach2(int[] A, int m, int[] B, int n) {

        for (int i = m + n - 1, a = m - 1, b = n - 1; b >= 0; i--) {
            if (a >= 0 && A[a] > B[b])
                A[i] = A[a--];
            else A[i] = B[b--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeUsingApproach1(nums1, nums2.length, nums2, nums2.length);
        mergeUsingApproach2(nums1, nums2.length, nums2, nums2.length);
    }
}
