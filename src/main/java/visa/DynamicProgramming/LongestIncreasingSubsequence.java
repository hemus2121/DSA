package visa.DynamicProgramming;

public class LongestIncreasingSubsequence {

    public static  int lengthOfLIS(int[] nums) {
        int n =  nums.length;
        int [] dp= new int[n];
        int maxCount =-1;
        dp[0]=1;
        //kep increasing from 1st element
        for(int i =1;i< n ;i++){
            int c=0;
            for (int j =0;j <i;j++){
                //check for strict smaller elements
                if (nums[j]< nums[i]){
                    c = Math.max(c, dp[j]);
                }
                dp[i]=c+1; //add +1 for previous value to account for current element
                maxCount = Math.max(maxCount, dp[i]);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
