package Scal.Arrays;

/* Largest Continuous Sequence Zero Sum

Problem Description
Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

 */
import java.util.*;

public class LargestContinuousSeq0Sum {
    private static int [] getLargestContinuousSeqZeroSum(int [] A){

        //Compute Prefix Array
        int [] pf = new int [A.length];
        pf [0] = A[0];
        for (int i =1;i< A.length;i++){
            pf[i] = pf[i-1] +A[i];
        }



        //Need Map to store 1st index of element and next to compute distance for repeating elements in prefiArray
        Map<Integer, Integer> indexMap = new HashMap<>();
        // store max length and start index of the max subarray
        int maxLength = 0;
        int startIndex = 0;

        //Base Case to handle edge case indicating 0 is found at -1 index
        indexMap.put(0, -1);

        //Iterate PF array and compute max distance and startIndex
        for (int i =0;i< pf.length;i++){
            if (indexMap.containsKey(pf[i])){
                // subarray with sum=0 found
                // calculate the length of the subarray
                int firstIndex = indexMap.get(pf[i]);
                int currentLen = i - firstIndex; // (current index - previous index)
                if (currentLen > maxLength){
                    maxLength = currentLen;
                    startIndex = firstIndex;
                }
            }else {
                indexMap.put(pf[i],i);
            }
        }

        //System.out.println ("max lenght: "+ maxLength +  " startIndex:"+startIndex);

        //Now iterate and return result since we got distance and startindex
        List<Integer> resultList= new ArrayList<>();
        for( int i = startIndex+1;i < startIndex+maxLength+1;i++){
            resultList.add(A[i]);
        }

        return  resultList.stream().mapToInt(val ->val).toArray();
    }

    public static void main(String[] args) {
        int [] data = {1,2,-2,4,-4};
        System.out.println(Arrays.toString(getLargestContinuousSeqZeroSum(data))); //expected - [2, -2, 4, -4]
    }
}
