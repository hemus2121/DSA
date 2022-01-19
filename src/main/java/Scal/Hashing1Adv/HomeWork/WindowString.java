package Scal.Hashing1Adv.HomeWork;

import java.util.*;

public class WindowString {

    private static String minWindow(String s, String t){
        //edge case
        if (s.length() < t.length())
            return "";
        // pattern map- convert every character of t into frequency map
        Map<Character, Integer> freqMap = new HashMap();
        for (char c : t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }

        int requiredLen = t.length();
        int min = Integer.MAX_VALUE;
        int matchedCount=0;
        int start =0;
        String res=null;
        // start 2nd pointer from 0th index only
         for (int end=0;end< s.length();end++){
             char c = s.charAt(end);
             // in contained in frequency of destination,reduce frequecy in map
             if (freqMap.containsKey(c)){
                 freqMap.put(c, freqMap.get(c)-1);
                 if (freqMap.get(c) >= 0) {
                     // since it matched increase match count
                     matchedCount++;
                 }
             }

             // check condition whether matchedCount == required length and start <= end

             while (matchedCount == requiredLen && start <= end) {
                 //check condition if length of substring is less than equal to original string
                 // if yes reduce original minimum and populate response to be substring between start,end
                 if (min >= end-start+1){
                     min= end-start+1;
                     res = s.substring(start,end+1);
                 }
                 // increment start pointer if there is match to check next match
                 char startC = s.charAt(start++);
                 //check if map contains that character
                 if (freqMap.containsKey(startC)){
                     //check if count is ZERO already then it exceed limit
                     if (freqMap.get(startC)==0){
                         matchedCount--;
                     }
                     freqMap.put(startC,freqMap.getOrDefault(startC,0)+1);
                 }
             }
         }
         return res;
    }

    public static String getMinWindow(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        char[] b = B.toCharArray();
        for (char value : b) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int resLen = Integer.MAX_VALUE;
        int t = map.size();
        int l = 0;
        int r = 0;
        StringBuilder str = new StringBuilder();
        while (r < A.length()) {
            if (map.containsKey(A.charAt(r))) {
                // if there is duplicates it will be handled A[AAAAAA] B[AA]
                if (map.get(A.charAt(r)) == 1) {
                 --t;
                }
                //already found reduce frequency
                map.put(A.charAt(r), map.get(A.charAt(r)) - 1);
            }
            while (t == 0) {
                if (resLen > (r - l + 1)) {
                    str.delete(0, str.length());
                    str.append(A, l, l + (r - l + 1));
                    resLen = str.length();
                }
                if (map.containsKey(A.charAt(l))) {
                    int val = map.get(A.charAt(l));
                    if (val == 0) {
                        ++t;
                    }
                    map.put(A.charAt(l), val + 1);
                }
                l++;
            }
            r++;
        }
        return str.toString();
    }
    public static void main(String[] args) {
        //System.out.println(minWindow("ADOBECODEBANC","ABC"));
        //System.out.println(getMinWindow("ADOBECODEBANC","ABC"));
        System.out.println(getMinWindow("AAAAAA","AA"));
        
    }
}
