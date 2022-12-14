package Visa.Arrays;

import java.util.HashMap;
import java.util.Map;

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
}
