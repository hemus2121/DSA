package Visa.Arrays;

import java.util.HashMap;
import java.util.Map;

/**  SubArray Sum Equals K
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * TC: O(N) and SC: O(N)
 */
public class SubArrayWithSumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count =0, currSum=0;
        // using concept of Prefix Array and map to store previous stored values
        // store values of count of how manytimes pf count was seen before
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i =0;i< nums.length;i++){
            currSum += nums[i];
            //check if current sum == required value
            if (currSum== k) count++;

            if (countMap.containsKey(currSum-k)){
                count += countMap.get(currSum-k);
            }
            //update count in map
            countMap.put(currSum, countMap.getOrDefault(currSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,1};
        System.out.println(subarraySum(nums,2));
    }
}
