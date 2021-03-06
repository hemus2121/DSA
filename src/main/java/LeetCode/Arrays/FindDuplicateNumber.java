package LeetCode.Arrays;
/*  Find the Duplicate Number -https://leetcode.com/problems/find-the-duplicate-number/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindDuplicateNumber {

    /*Approach
    using slow and fast pointers approach
    since there is a duplicate, while sorting there would be a cycle
    detect the cycle using slow and fast pointers, moving former once and latter twice
    once cycle is detected, move slow to the beginning

    move both pointers ONCE
    once pointers meet, we found the beginning of the cycle, this is the repeating element
    */

    private static int findDuplicateNumber(int [] nums){

        int slow = nums [0];
        int fast = nums [0];

        // detect cycle
        // Find the intersection point of the two runners.
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        // Find the "entrance" to the cycle. moving 2 pointers 1 at a time
        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int  [] A = {1,3,4,2,2}; //Expected 2
        System.out.println(findDuplicateNumber(A));
    }
}
