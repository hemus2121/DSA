package ArraysProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    //time O(n^3) || space O(n)
    private static List<Integer[]> foursum (int []array, int target){
        List<Integer[]> responseList = new ArrayList<>();

        //Key idea here is to sort the array first. Then start from left to pick the first element to be a, then find if there are two other elements b, c make a + b + c = 0.
        // Another thing to keep in mind is that how to avoid duplicate answers.
        Arrays.sort(array);

        // IMP --> iterate through array one by one choose last-2 because we want to have atleast element after it to consider for summation
        for (int i=0;i<array.length-3;i++) {

            //left and right pointers starting form 1 and last-1 elements respectively

            for (int j = i+1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;

                while (left < right) {
                    int summation = array[i] + array[j] + array[left] + array[right];
                    if (target == summation) {
                        Integer[] resdata = new Integer[]{array[i], array[j], array[left], array[right]};
                        left++;
                        right--;
                        responseList.add(resdata);
                    } else if (summation < target) {
                        left++;
                    } else if (summation > target) {
                        right--;
                    }
                }
            }
        }
        return responseList;
    }

    public static void main(String[] args) {
        List<Integer[]> results = foursum(new int[] {1, 0, -1, 0, -2, 2}, 0);

        results.stream().forEach(integers -> {
            System.out.println(Arrays.toString(integers));
        });

    }
}
