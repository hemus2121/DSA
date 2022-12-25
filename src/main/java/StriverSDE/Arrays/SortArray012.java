package StriverSDE.Arrays;

import java.util.Arrays;

/** Sort an array of 0s, 1s and 2s
 * Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
 */
public class SortArray012 {
    //using 3 pointer approach
    private static void sortColors (int [] data){
        int low=0, high= data.length-1, mid=0;
        while (mid <= high){
             if ( data[mid]==0){ // swap with low element and increment both
                 swap (data, low, mid);
                 low++;
                 mid++;
             }else if (data [mid]==2){ // swap with last element and increment decrement only last
                 swap (data, mid, high);
                 high--;
             }else mid++; // if 1 comes just retain there and increment pointer
        }
    }
     static void swap (int [] data, int low, int high){
        int tmp = data[low];
        data[low] = data[high];
        data[high] =tmp;
    }
    public static void main(String[] args) {
        int [] data = {0,1,0,2,0,2,1};
        sortColors(data);
        System.out.println(Arrays.toString(data));
    }
}
