package ArraysProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  //TC O(n^2) || SCs O(n)
    private static List<List<Integer>> threeSum(int [] nums, int target){

        //Key idea here is to sort the array first. Then start from left to pick the first element to be a, then find if there are two other elements b, c make a + b + c = 0.
        // Another thing to keep in mind is that how to avoid duplicate answers.
        List<List<Integer>> resultList = new ArrayList<>();
        //sort the array first
        Arrays.sort(nums);

        //iterate from start to n-2 since we need 3 count
        for (int i =0;i< nums.length-2;i++){
            if (i==0 || i >0 && nums[i] != nums[i-1]){
                //initalize 2 pointers
                int left = i+1;
                int right = nums.length-1;
                //int sum= 0-nums[i];

                while (left <right){
                    if (nums[left] + nums[right] +nums[i]==0){

                        resultList.add(Arrays.asList(nums[i],nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left ++;
                        right --;
                    }
                    else if (nums[left] + nums[right] + nums[i] < 0){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        //List<Integer[]> results = threeSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
       // results.stream().forEach(integers -> {
       //     System.out.println(Arrays.toString(integers));
      //  });


        List<List<Integer>> results1 = threeSum(new int[] { -1,0,1,2,-1,-4}, 0);
        results1.stream().forEach(integers -> {
            System.out.println((integers));
        });
    }
}
