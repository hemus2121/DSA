package visa.Arrays;

//In this pattern we simply place the elements of the array on their positions( or at least try to ), like 1 should be at 1st position and 2 at the second position, and then we iterate again and check if for any index we have an element whose value is not equal to index + 1, then that is the missing number.
// https://leetcode.com/problems/first-missing-positive/discuss/858526/Cyclic-Sort-Explained
public class FirstMissingInteger {
    public int firstMissingPositive(int[] nums) {
        int i =0;

        while(i <nums.length){
            // check within boundary and see whether its not at its correct position
            if ( nums[i] >0 && nums[i]<= nums.length && nums[i] != nums [nums[i]-1]){
                swap (nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        //check first not matching number with index
        for ( i =0;i< nums.length;i++){
            if (nums[i] != i+1){
                return i+1;
            }
        }
        // just last number is
        return nums.length+1;
    }

    void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums [i]= nums[j];
        nums[j] = temp;
    }
}
