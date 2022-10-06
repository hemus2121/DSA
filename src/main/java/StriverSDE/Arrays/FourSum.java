package StriverSDE.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Four sum
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 *     0 <= a, b, c, d < n
 *     a, b, c, and d are distinct.
 *     nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 *
 */
public class FourSum {
    private static List<Integer[]> foursum (int []array, int target){

        List <Integer[]> resultList = new ArrayList<>();

        //sort input array
        Arrays.sort(array);
        // IMP --> iterate through array one by one choose last-2 because we want to have atleast element after it to consider for summation
        for (int i=0;i< array.length-3;i++){
            for (int j =i+1;j< array.length-2;j++){
                int left = j+1;
                int right = array.length-1;

                while (left <right){
                    int summation = array[i] + array[j] + array[left] + array[right];
                    if (target == summation){
                        Integer[] result = new Integer []{array[i] , array[j], array[left], array[right] };
                        left++;
                        right--;
                        resultList.add(result);
                    }else if (summation < target){
                        left++;
                    }else if (summation > target){
                        right--;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer[]> results = foursum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        results.stream().forEach(integers -> {
            System.out.println(Arrays.toString(integers));
        });
    }
}
