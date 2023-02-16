package Scal.DynamicProg;

/** Jump Game
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 * https://leetcode.com/problems/jump-game/discuss/2336291/Very-Easy-100(Fully-Explained)(JavaC%2B%2B-Python-JS-C-Python3)
 */
public class JumpGame {
    public static  boolean canJump(int[] nums) {
        // Take curr variable to keep the current maximum jump...
        int curr = 0;
        for (int i =0;i<nums.length;i++){
            // If the current index 'i' is greater than current maximum jump 'curr'...
            // It means there is no way to jump to current index...
            // so we should return false...
            if (i > curr) return  false;
            curr = Math.max(curr, i + nums[i]);
        }
        return true;
    }


    //https://dev.to/samuelhinchliffe/55-jump-game-1pfb#:~:text=Input%3A%20nums%20%3D%20%5B2%2C,steps%20to%20the%20last%20index.
    public static  boolean canJump2(int[] nums) {

        int goal_post = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int jump_distance = i + nums[i];
            if (jump_distance >= goal_post) {
                goal_post = i;
            }
        }
        return (goal_post == 0) ? true : false;
    }
    public static void main(String[] args) {
        int [] data = { 2,3,1,1,4};
        System.out.println(canJump(data));
    }
}
