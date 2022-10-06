package StriverSDE.Arrays;

import java.util.HashMap;
import java.util.Map;

/** Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * TC: O(N)
 * SC: O(N) where N represents the size of HashSet where we are storing our elements
 */
public class LongestSubstringwithoutrepeat {
    public static int getLongestSubString(String s){
        //to store character last seen index
        Map<Character, Integer> indexMap = new HashMap<>();

        int left=0, right=0;
        int n = s.length();
        int len=0;
        while(right <n){
            if (indexMap.containsKey(s.charAt(right))){
                left = Math.max(indexMap.get(s.charAt(right)), left);// checking if range is with in L- r range if its left of left dont update take left only
            }
            indexMap.put(s.charAt(right), right);
            len = Math.max(len, right-left+1);
            right++;
        }
        return len;
    }
    public static void main(String[] args) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating characters is " + getLongestSubString(str)); //expected 9
    }
}
