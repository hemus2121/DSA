package visa;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    static String customCharSort (char [] data){
        Arrays.sort(data);
        return new String(data);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // place holder needed for storing anagrams
        Map<String ,List<String>> hm = new HashMap<>();

        //iterate over string array
        for (int i =0;i< strs.length;i++) {
            char[] data = strs[i].toCharArray();
            String sortedValue = customCharSort(data);

            // check if persent in map - if YES - Add to list
            if (hm.containsKey(sortedValue)) {
                hm.get(sortedValue).add(strs[i]);
            } else {
                hm.put(sortedValue, new ArrayList<>());
                hm.get(sortedValue).add(strs[i]);
            }
        }
        return new ArrayList<>(hm.values());
    }

    public static void main(String[] args) {
        String [] data = { "eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(data));
    }
}
