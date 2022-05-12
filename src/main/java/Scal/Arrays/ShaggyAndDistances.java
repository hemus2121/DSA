package Scal.Arrays;
/* Shaggy and distances
Problem Description

Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|.
If there is no special pair in the array, then return -1.
 */

import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistances {
    private static int getDistances(int []A){

        Map<Integer,Integer> indexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        //Iterate over array elements computing minimum index distance between repeating elements
        for (int i =0;i< A.length;i++){
            if (indexMap.containsKey(A[i])){
                minDistance = Math.min(minDistance, i - indexMap.get(A[i]));
            }else{
                indexMap.put(A[i],i);
            }
        }
        return (minDistance == Integer.MAX_VALUE)? -1: minDistance;
    }

    public static void main(String[] args) {
        int [] data = {7, 1, 3, 4, 1, 7};
        System.out.println(getDistances(data)); //expected=3
        int [] data1 = {1,1};
        System.out.println(getDistances(data1)); //expected=1
    }
}
