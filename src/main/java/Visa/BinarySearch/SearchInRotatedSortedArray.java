package Visa.BinarySearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/763245/0ms-100-faster-O(log(n))-binary-search-easy-with-explaination-in-comments
//https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14472/Java-AC-Solution-using-once-binary-search
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int start =0, end = nums.length, mid;

        while (start <= end){
            mid = (start+end)/2;
            //check if required element is middle element
            if (nums[mid]== target) return mid;

            if(nums[start] <= nums[mid]){
                //checking if first half array is sorted if so
                if (nums[start]<= target && target  <nums[mid]){ //check if target lies in the range if so
                    end = mid -1;  // search in first half only
                }else  start = mid+1;  //else search in second half
            }else {
                //if first half isn't sorted go and check for second
                if (nums[mid]<target  && target<= nums[end]){ //check if target lies in second half
                    start = mid+1;  //if so search in second half
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] data = { 4,5,6,7,0,1,2};
        System.out.println(search(data,0));
    }
}
