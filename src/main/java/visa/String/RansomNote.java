package visa.String;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/ransom-note/
public class RansomNote {
    public static  boolean canConstruct(String ransomNote, String magazine) {
        //edge case
         if (ransomNote.length() > magazine.length()) return false;

         //Store reference string character count in map
        Map<Character, Integer> dataMap = new HashMap<>();
         for (char c: magazine.toCharArray()){
             dataMap.put(c, dataMap.getOrDefault(c,0)+1);
         }

         //iterate required character string character values
        for (char c : ransomNote.toCharArray()){
            int count = dataMap.get(c);
            if (count == 0) return  false;
            // reduce and update map
            dataMap.put(c, count-1);
        }
        return true;
    }
        public static void main(String[] args) {
            String s1 ="aa", s2 ="b";
            System.out.println(canConstruct(s1, s2));

    }
}
