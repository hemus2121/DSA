package StriverSDE.Arrays;

/** Length of the longest subarray with zero Sum
 * Problem Statement: Given an array containing both positive and negative integers,
 * we have to find the length of the longest subarray with the sum of all elements equal to zero.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestsubarraywithzeroSum {
    private static int getMAximumSubArraywithZeroSum(int []A ){

        //Use Prefix array and Hashmap- this keeps track for index of previous prefix values

        Map<Integer,Integer> prefixMap = new HashMap<>();
        int maxi =0;
        int pfSum =0;
        for (int i = 0; i< A.length; i++){
            pfSum += A[i];

            //check if pfSume is Zero
            if (pfSum ==0){
                maxi = maxi+1; // longest since we are taking prefix sum
            }else {
                if (prefixMap.containsKey(pfSum)){
                    maxi = Math.max(maxi, i- prefixMap.get(pfSum));
                }else {
                    prefixMap.put(pfSum, i);
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int [] data = { 9, -3, 3, -1, 6, -5};
        System.out.println(getMAximumSubArraywithZeroSum(data)); //expected 5
    }
}
