package General;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {

    static Set<List<Integer>> lists;

    public static List<List<Integer>> findSubsequences(int[] nums) {
        lists = new HashSet<>();
        recursion(nums, 0, new ArrayList());

        return new ArrayList(lists);
    }

    static void recursion(int[] nums, int curr, List<Integer> temp) {
        if (temp.size() >= 2)
            lists.add(new ArrayList(temp));

        for (int i = curr; i < nums.length; i++) {
            if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
                temp.add(nums[i]);
                recursion(nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int [] data = new int [] { 4,6,7,7};
        System.out.println(findSubsequences(data));
    }
}
