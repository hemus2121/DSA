package StriverSDE.Arrays;

/**
 * In-place merge two sorted arrays
 * Given two sorted arrays, X[] and Y[] of size m and n each, merge elements of X[] with elements of array Y[] by maintaining the sorted order, i.e., fill X[] with the first m smallest elements and fill Y[] with remaining elements.
 * TC: O(n*m)
 * SC: O(1)
 */

import java.util.Arrays;

public class MergeTwoSortedArraysNoExtraSpace {

    static void merge(int[] arr1, int arr2[], int n, int m) {
        // code here
        int i, k;
        for (i = 0; i < n; i++) {
            // take first element from arr1
            // compare it with first element of second array
            // if condition match, then swap
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            // then sort the second array
            // put the element in its correct position
            // so that next cycle can swap elements correctly
            int first = arr2[0];
            // INSERTION SORT is used here
            for (k = 1; k < m && arr2[k] < first; k++) {
                arr2[k - 1] = arr2[k];
            }
            arr2[k - 1] = first;
        }
    }
    public static void main(String[] args) {
        int [] arr1 ={ 1,4,7, 8, 10};
        int [] arr2= {2, 3,9};
        merge(arr1, arr2,arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1) + " --" +Arrays.toString(arr2));
    }
}
