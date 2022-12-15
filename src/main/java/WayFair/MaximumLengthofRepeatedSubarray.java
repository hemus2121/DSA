package WayFair;

public class MaximumLengthofRepeatedSubarray {

    static int getMaxLengthOfSubArray (int [] nums1, int [] nums2){
        int n = nums1.length;
        int m = nums2.length;

        //create dp array
        int [][] dp = new int [ n+1][m+1];

        int ans=0;

        //lets iterate from backside
        for(int ind1= n-1;ind1>=0;ind1--){
            for(int ind2= m-1;ind2 >=0;ind2--){
                if (nums1[ind1]== nums2[ind2]){
                    dp[ind1][ind2] = 1+ dp[ind1+1][ind2+1];
                    if (ans < dp[ind1][ind2]){
                        ans = dp[ind1][ind2];
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] data1 ={1,2,3,2,1};
        int [] data2 ={3,2,1,4,7};
        System.out.println(getMaxLengthOfSubArray(data1, data2));
    }
}
