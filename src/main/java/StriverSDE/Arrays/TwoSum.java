package StriverSDE.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Two Sum  Check if a pair with given sum exists in Array
 * Problem Statement: Given an array of integers nums[] and an integer target, return indices of the two numbers such that their sum is equal to the target.
 *
 */
public class TwoSum {
    private static int [] twoSum(int [] number, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> targetMap = new HashMap<>(); //store key as number and index as value

        //iterate over numbers checking for difference of target - number if exists in map
        for (int i = 0; i < number.length; i++) {
            if (targetMap.containsKey(target - number[i])) {
                result[0] = i;
                result[1] = targetMap.get(target - number[i]);
                return result;
            }
            targetMap.put(number[i], i);
        }
        return  result;
    }
    public static void main(String[] args) {
        int [] data = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(data, target)));
    }
}
