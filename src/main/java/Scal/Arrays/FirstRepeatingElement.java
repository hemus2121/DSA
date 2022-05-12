package Scal.Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Problem Description

Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
If there is no repeating element, return -1.
 */
public class FirstRepeatingElement {
    private static int getFirstRepeatingElement(int [] A){

        //Store the frequency of each element
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int a : A){
            if (freqMap.containsKey(a)){
                freqMap.put(a, freqMap.get(a)+1);
            }else {
                freqMap.put(a, 1);
            }
        }

        //Iterate Array elements in sequence and return element whose frequency is more than 1
        for (int a : A){
            if (freqMap.containsKey(a) && freqMap.get(a) >1){
                return a;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] data = { 10, 5, 3, 4, 3, 5, 6};
        System.out.println(getFirstRepeatingElement(data)); //expected 5

    }
}
