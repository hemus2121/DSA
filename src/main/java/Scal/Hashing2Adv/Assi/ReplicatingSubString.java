package Scal.Hashing2Adv.Assi;

import java.util.*;

/*
Problem Description

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
If it is possible, return 1, else return -1.
 */
public class ReplicatingSubString {

    private static int checkReplicatingSubString(int A, String B){

        //Hint: Construct map to get frequency count of characters in String B
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c: B.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
             //check in collection if required data is not present
        Optional <Integer> opt= freqMap.values().stream().filter(val-> val%A!=0).findFirst();
        return opt.isPresent()? -1:1;
        //for (Integer val:values){
        //    if (val %A!=0) return -1;
        //}
       // return 1;
    }

    public static void main(String[] args) {
        System.out.println(checkReplicatingSubString(2,"bbaabb"));
    }
}
