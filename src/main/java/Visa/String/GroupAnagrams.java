package Visa.String;
/** Group Anagrams
* Given an array of strings strs, group the anagrams together. You can return the answer in any order.
*An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        //stores the group of anagrams
        Map <String, List<String>> freqMap = new HashMap();
        for (String s : strs){

            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String sortedValue = String.valueOf(ca);

            //check that sorted value is present as key in HM
            // if present add the actual string value to existing list
            if (freqMap.containsKey(sortedValue)){
                freqMap.get(sortedValue).add(s);
            }else {
                freqMap.put(sortedValue, new LinkedList<>());
                freqMap.get(sortedValue).add(s);
            }
        }

        //iterate over the map the get values and return array list
        return new ArrayList(freqMap.values());
    }

    public static void main(String[] args) {
        String [] data = { "eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(data));
    }
}
