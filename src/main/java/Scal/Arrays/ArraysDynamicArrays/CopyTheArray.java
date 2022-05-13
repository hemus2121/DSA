package Scal.Arrays.ArraysDynamicArrays;

import java.util.Arrays;
/* Copy the Array
Problem Description
You are given a constant array A and an integer B.
You are required to return another array where outArr[i] = A[i] + B.
 */

public class CopyTheArray {
    static int[] copyTheArray(int [] A,int B){
        int [] outputArray = new int [A.length];
        int index=0;
        for (int a : A){
            outputArray[index++]= a+B;
        }
        return outputArray;
    }

    public static void main(String[] args) {
        int [] data = {1,2,3,2,1};
        System.out.println(Arrays.toString(copyTheArray(data, 3))); //[4,5,6,5,4]
    }
}
