package Scal.DynamicProg;

/** Combination Sum IV
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * https://leetcode.com/problems/combination-sum-iv/discuss/2381079/Java-or-1ms-or-DP-or-Top-Down-or-memoization-or-easy
 */
public class CombinationSum1V {

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for (int i =1; i<=target;i++){
            for ( int num :nums){
                if (num <=i){
                    dp[i] += dp [i-num];
                }
            }
        }
        return dp [target];
    }

    public static void main(String[] args) {
        int [] nums = { 1, 2,3 };
        int target =4;
        System.out.println(combinationSum4(nums, target));
    }
}
