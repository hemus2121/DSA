package StriverSDE.Arrays;

/** Majority Element
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * TC : O(N)
 * SC: O(1)
 */
public class MajorityElementNBy2 {

    //using Booyee Moore Majority Voting Algo
    public static int majorityElement(int[] nums) {
        int count=0 ; // for tracking count of element;
        int element =0; // for tracking which element we are counting

        for (int num : nums){
            if (count ==0){
                element = num;
            }
            if(num == element) count++;
            else count--;
        }
        return element;

    }
    public static void main(String[] args) {
     int [] data = { 3, 2,3};
        System.out.println(majorityElement(data));
    }
}
