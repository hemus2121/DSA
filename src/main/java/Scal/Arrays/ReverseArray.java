package Scal.Arrays;

import java.util.Arrays;

/*Problem Description
You are given a constant array A.
You are required to return another array which is the reversed form of the input array.
 */

public class ReverseArray {
    private static int [] reverseArray (final int []A){
        int i =0;
        int j = A.length-1;
        int [] result = new int [A.length];
        while ( j >=0){
            result[i++] = A[j--];
        }
        return  result;
    }
    public static void main(String[] args) {
        int [] data = { 1, 2, 3,4};
        System.out.println(Arrays.toString(reverseArray(data)));
    }
}
