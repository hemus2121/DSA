package StriverSDE.LinkedListArrays;

/** MaxConsecutive Once - Count Maximum Consecutive One’s in the array
 * Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
 */
public class MaxConsecutiveOnes {
    private static int getCons1sCount(int [] nums){

        int maxCount=Integer.MIN_VALUE, currentCount =0;

        for (int i=0;i< nums.length;i++){
            if ( nums[i] ==1){
                currentCount++;
            }else {
                currentCount =0; // reset to ZERO count and we shall restart counter again 
            }
            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int [] data = {1, 0, 1, 1, 0, 1};
        System.out.println(getCons1sCount(data)); //expected -2
    }
}
