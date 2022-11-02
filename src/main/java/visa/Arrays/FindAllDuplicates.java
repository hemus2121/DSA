package visa.Arrays;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/discuss/1505522/Java-Linear-time-solution-with-a-hashset-trick-O(1)-Auxiliary-Space

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List <Integer> res = new ArrayList<>();
        for (int i=0;i< nums.length;i++){
            int idx = Math.abs(nums[i])-1; /// Get the mapped index for nums[i], using Math.abs only once
            if (nums[idx] <0){ // Check if nums[i] has been seen before, if true then add to the output list
                res.add(idx+1) ;// Need to add +1 as our range is 1-based
            }
            // Unconditionally flip sign, if it's positive, we want to mark it as negative. But if it's negative,
            // we just recover previous value so that at the end our array is not modified
            nums[idx] *=-1;
        }
        return res;
    }
}
