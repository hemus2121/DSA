package ArraysProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  //time O(n^2) || space O(n)
    private static List<Integer[]> threeSum(int [] array, int target){
        List<Integer[]> response = new ArrayList();

        //Key idea here is to sort the array first. Then start from left to pick the first element to be a, then find if there are two other elements b, c make a + b + c = 0.
        // Another thing to keep in mind is that how to avoid duplicate answers.
        Arrays.sort(array);

        // IMP --> iterate through array one by one choose last-2 because we want to have atleast element after it to consider for summation
        for (int i =0;i< array.length-2;i++){

            //left and right pointers starting form 1 and last-1 elements respectively
             int left = i+1, right = array.length-1;
             while (left < right) {
                  int currentSum = array[i] + array[left] +array[right];
                  if (currentSum == target) {
                      Integer[] result = new Integer[]{array[i], array[left], array[right]};
                      left++;
                      right--;
                      response.add(result);
                  } else if (currentSum < target){
                      left ++;
                  } else if (currentSum > target){
                      right --;
                  }
             }
        }
        return response;
    }

    public static void main(String[] args) {
        List<Integer[]> results = threeSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        results.stream().forEach(integers -> {
            System.out.println(Arrays.toString(integers));
        });
    }
}
