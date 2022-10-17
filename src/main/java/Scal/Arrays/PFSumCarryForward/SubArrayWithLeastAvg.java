package Scal.Arrays.PFSumCarryForward;

/** Subarray with least average
 * Problem Description
 * Given an array of size N, find the subarray of size K with the least average.
 */
public class SubArrayWithLeastAvg {
    static int getIndexOfSubArray(int [] A, int B){

        int currSum=0;
        //compute sum for 1st window - SLIDING WINDOW
        for(int i =0;i< B;i++){
            currSum += A[i];
        }

        int minsum = currSum;
        int index=0;
        for (int i =1;i<= A.length-B;i++){
            currSum = currSum - A[i-1] + A[i+B-1];
            if (currSum< minsum){
                minsum= currSum;
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int [] data = { 3, 7, 90, 20, 10, 50, 40 };
        System.out.println(getIndexOfSubArray(data, 3));
    }
}
