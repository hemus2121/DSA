package StriverSDE.Arrays;

/** Fina the duplicate in an array of N+1 elements
 * Problem Statement: Given an array of N + 1 size, where each element is between 1 and N.
 * Assuming there is only one duplicate number, your task is to find the duplicate number.
 * must sove the problme without modifying array and uses only constant extra space
 */
public class FindDuplicate {

    //Using LINKED LIST CYCLE METHOD
    public static int findDuplicate(int[] nums) {
        int slow= nums[0], fast = nums[0];

        do{
            slow = nums [slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        //reset fast to start
        fast = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        int [] nums = { 1, 3, 4, 2,2};
        System.out.println(findDuplicate(nums));
    }
}
