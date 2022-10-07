package StriverSDE.LinkedListArrays;

/** Remove Duplicates in-place from Sorted Array
 * Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Note: Return k after placing the final result in the first k slots of the array.
 */
public class RemoveDuplicateFromSortedArray {
    private static int  removeDuplicateFromSortedArray(int [] nums){
        //solve using 2 pointers
        // - i moves slowly and tells where to insert new character
        // -- j moves and check for new incoming character
        int i =0;
        for (int j =1;j< nums.length;j++){
            // if new number has come put that in updated ith position
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;// return location which is unique elements are copied
    }
    public static void main(String[] args) {
        int [] data = {1,1,2,2,2,3,3};
        System.out.println(removeDuplicateFromSortedArray(data));
    }
}
