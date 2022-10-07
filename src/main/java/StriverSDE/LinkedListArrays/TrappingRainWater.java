package StriverSDE.LinkedListArrays;

/** Trapping Rainwater
 * Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
 */
public class TrappingRainWater {

    //Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.
    //Space Complexity: O(N)+O(N) for prefix and suffix arrays.
    private static int getTrappedWater(int [] A){

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
    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getTrappedWater(A)); //expected 6
    }
}
