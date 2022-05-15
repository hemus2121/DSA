package Scal.Arrays.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
NOTE: if B > N, return an empty array.
 */
public class DistinctNumbersInWindow {
    private static int [] getDistinctNumbers(int [] A, int B){
        //ths is Sliding window problem of size B
        Map<Integer, Integer> freqMap= new HashMap<>();

        //Result
        ArrayList<Integer> responseList = new ArrayList<>();

        //iterate for 1st window of size B
        for (int i =0;i< B;i++){
            if (freqMap.containsKey( A[i])){
                freqMap.put(A[i], freqMap.get(A[i])+1);
            }else {
                freqMap. put(A[i],1);
            }
        }
        responseList.add(freqMap.size());

        //Now iterate for next set of element
        for (int i =B;i<= A.length-1;i++){
            // incoming element
            if (freqMap.containsKey(A[i])){
                freqMap.put(A[i], freqMap.get(A[i])+1);
            } else freqMap.put(A[i],1);

            //Handling outgoing elemnent
              // 1. Reduce freq of outgoing element
             if (freqMap.containsKey(A[i-B])){
                 freqMap.put(A[i-B], freqMap.get(A[i-B])-1);
             }

              //2. if  freq is ZERO remove the entry from Map
             if (freqMap.get(A[i-B])==0){
                 freqMap.remove(A[i-B]);
             }

             responseList.add(freqMap.size());
        }
        return responseList.stream().mapToInt(val ->val).toArray();
    }

    public static void main(String[] args) {
        int [] data = {1, 2, 1, 3, 4, 3};
        System.out.println(Arrays.toString(getDistinctNumbers(data, 3 ))); //expected [2,3,3,2]
    }
}
