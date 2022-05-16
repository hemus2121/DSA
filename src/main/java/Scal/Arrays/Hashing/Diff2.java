package Scal.Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

/*  Diffk II
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 */
public class Diff2 {
    private static int checkDiffPossible(int [] A, int B){
        //Store the element in hashmap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int a : A){
            if ( freqMap.containsKey( a)){
                freqMap.put(a, freqMap.get(a)+1);
            }else freqMap.put(a, 1);
        }

        // now iterate array element and check for pair element
        for (int ele : A){
            int a = ele;
            int diff = a-B;
            if ( a != diff && freqMap.containsKey( diff)) return 1;
            // handling duplicate case
            else if ( a==diff) {
                if (freqMap.get(a) >= 2) return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int [] data = { 1, 5, 3};
        System.out.println(checkDiffPossible(data, 2)); //expected 1
    }
}
