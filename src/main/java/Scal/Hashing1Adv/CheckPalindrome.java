package Scal.Hashing1Adv;

/*
Problem Description

Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {
    private static int checkPalindrome(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        //iterate over character array of string store freq in map
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        //odd count >1 then its false
        int oddcount=0;
        Collection<Integer> list =freqMap.values();
        for (Integer val : list){
            if (val%2==1) oddcount++;
        }
        return oddcount>1?0:1;

    }


    public static void main(String[] args) {
        System.out.println(checkPalindrome("abcde"));
        System.out.println(checkPalindrome("abbaee"));
    }
}
