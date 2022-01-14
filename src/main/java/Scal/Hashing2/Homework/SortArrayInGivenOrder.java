package Scal.Hashing2.Homework;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/*
Problem Description

Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B. For the elements not present in B, append them at last in sorted order.

Return the array A after sorting from the above method.

NOTE: Elements of B are unique.
 */
public class SortArrayInGivenOrder {
    private static int [] sort(int []A, int []B ){
        Map<Integer,Integer> freqMap = new TreeMap<>();

        // store the elements from A into freq map
        for (int a :A){
            freqMap.put(a, freqMap.getOrDefault(a,0)+1);
        }

        //response list
        List <Integer> responseList = new ArrayList<>() ;

        //iterate over element in B array, check in map and if present add to response and reduce count
        for (int b : B){
            if (freqMap.containsKey(b)){
                int value = freqMap.get(b);
                while (value >=1){
                    value--;
                    responseList.add(b);
                }
            }
            //remove unwated elements as such from map
            freqMap.remove(b);
        }

        //copy rest of element from freq map to response
        for (Map.Entry <Integer,Integer> entry: freqMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            while (value>=1){
                responseList.add(key);
                value--;
            }
        }
        //convert to array from list
        return responseList.stream().mapToInt(val-> val).toArray();
    }
    public static void main(String[] args) {
        int [] A = {3, 20, 17, 17 };
        int [] B = {5, 9, 20, 11, 6, 18, 7, 13};
        System.out.println(Arrays.toString(sort(A,B)));
    }
}