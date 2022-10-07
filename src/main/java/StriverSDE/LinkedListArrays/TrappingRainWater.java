package StriverSDE.LinkedListArrays;

/** Trapping Rainwater
 *  YT link - https://www.youtube.com/watch?v=m18Hntz4go8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=43
 * Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
 */
public class TrappingRainWater {

    //TC: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.
    //SC: O(N)+O(N) for prefix and suffix arrays.
    private static int getTrappedWaterExtraSpace(int [] A){

        int n = A.length;
        //declare 2 array to hold left max and right max
        int [] leftmax = new int [n];
        int [] rightmax = new int [n];

        //compute left max
        leftmax[0] = A[0];
        for (int i =1;i< n;i++){
            leftmax[i] = Math.max(leftmax[i-1], A[i]);
        }

        //compute right max - suffix array
        rightmax[n-1]= A[n-1];
        for (int i = n-2 ;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i+1], A[i]);
        }

        //compute total water
        int totalWater=0;
        for (int i=0;i< n;i++){
            totalWater+= Math.min(leftmax[i], rightmax[i])-A[i];
        }
        return totalWater;
    }

    //Using 2 pointer approach
    // TC:O(N) - 2 pointer approach
    // SC:O(1)
    private static int getTrappedWaterOptimal (int []height){
        int leftMax=0, rightMax=0, res=0;
        int left =0, right = height.length-1;

        while (left < right ){
             // 2 cases arise
            if (height[left] <= height[right]){
                if (height[left]>=leftMax){ // check if current left is maximum till now if YES - remaining leftMax value
                    leftMax = height[left];
                }else res += leftMax- height[left];

                 left++;
            } else {
                if (height[right] >= rightMax){
                    rightMax = height[right]; // check if current right is maximum till now if YES - remaining leftMax value
                }else {
                    res += rightMax- height[right];
                }
                right --;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getTrappedWaterExtraSpace(A)); //expected 6
        System.out.println(getTrappedWaterOptimal(A)); //expected 6
    }
}
