package Scal.Arrays;
/* Common Elements
Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
NOTE:
    Each element in the result should appear as many times as it appears in both arrays.
    The result can be in any order.
 */

import java.util.*;

public class CommonElements {

    private static int [] commonElements(int [] A, int [] B){

        //Frequency Map to store elements of 1st Array
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int a: A){
            if (freqMap.containsKey(a)){
                freqMap.put(a, freqMap.get(a)+1);
            }else {
                freqMap.put(a, 1);
            }
        }

        //Response place holder
        List<Integer> resultList = new ArrayList<>();
        for(int b : B){
            if (freqMap.containsKey(b) && freqMap.get(b)>0){
                resultList.add(b);
                //reduce frequencey also to ensure we have correct count of elements
                freqMap.put(b, freqMap.get(b)-1);
            }
        }
        return resultList.stream().mapToInt(val ->val).toArray();
    }

    public static void main(String[] args) {
        int [] A = { 1, 2, 2, 1};
        int [] B = { 2, 3, 1, 2};
        System.out.println(Arrays.toString(commonElements(A, B))); //expected [1, 2, 2]
    }
}
