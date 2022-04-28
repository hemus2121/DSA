package Scal.Arrays;

/* Closest Min Max

Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.

 */
public class ClosestMinMax {
    private static int getMinSubArrayLengthofMinMax(int []A){

        int max =A[0];
        int min = A[0];
        int n = A.length;

        // step 1:: finding max and min values inititally for complete array
        for (int a : A){
            max = Math.max(a,max);
            min = Math.min(a,min);
        }
        
        if (min==max) return 1; // if both are equal return 1

        // Step 2:: Initalized min, max indexes to being with as 2n(dummy values) and ans=n
        int maxIndex = 2*n, minIndex = 2*n, ans=n;

        //Step 3:: Iterate from Right to Left instead of default Left To Right
        for (int i =n-1;i>=0;i--){
            if (A[i] == max){  // now we need to get minimumIndex value
                ans = Math.min(ans, minIndex-i+1);
                maxIndex=i;
            }else  if(A[i]== min) { // now we need to get maximumIndex value
                ans = Math.min(ans, maxIndex-i+1);
                minIndex = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] data = { 1, 3};
        System.out.println(getMinSubArrayLengthofMinMax(data));
    }
}
