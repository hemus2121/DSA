package visa.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/1755435/Detailed-Explanation-or-Java-or-HashMap
public class FindAllAnagrams {
    static public List<Integer> findAnagrams(String s, String p) {
        // base condition
        if (p.length() > s.length()) return new ArrayList<>();

        // lets use create 2 frequency maps
        Map<Character, Integer> pmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();

        //creating pattern string freq map
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }
        // Creating source string frequency map upto pattern length as it'll fix window size
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }

        // start is pointing to very next after window
        int start = p.length();

        List<Integer> resList = new ArrayList<>();

        while (start < s.length()) {
            //comparing freq map of target patters
            if (compareMap(smap, pmap)) {
                // notice if frequency map of pattern and sliding window get match , add the index of very first character of sliding window
                // start -p.length() gives the required index
                resList.add(start - p.length());
            }

            //  INCOMING element adding element pointed by start in frequency map
            char arrival_char = s.charAt(start);
            smap.put(arrival_char, smap.getOrDefault(arrival_char, 0) + 1);

            // OUTGOING element
            // when sliding window moves we need to remove left most character from sliding window
            char going_Char = s.charAt(start - p.length());
            if (smap.get(going_Char) == 1)
                smap.remove(going_Char);
            else smap.put(going_Char, smap.get(going_Char) - 1);

            // increase start and it denotes moving window
            start++;
        }
        // at the end last sliding window charcters would be left checked , hence checking them also
        if (compareMap(smap, pmap)) {
            resList.add(start - p.length());
        }
        return resList;
    }

    static boolean compareMap(Map<Character, Integer> smap, Map<Character, Integer> pmap) {
        for (Character c : smap.keySet()) {
            if (pmap.containsKey(c)) {
                if ( pmap.get(c) != smap.get(c))
                    return false;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
