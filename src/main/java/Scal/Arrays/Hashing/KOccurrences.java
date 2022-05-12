package Scal.Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

/* K Occurrences
Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
He wants to select some trees to replace his broken branches.
But he wants uniformity in his selection of trees.
So he picks only those trees whose heights have frequency K.
He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).
But the sum he ended up getting was huge so he prints it modulo 10^9+7.
In case no such cluster exists, Groot becomes sad and prints -1.
 */
public class KOccurrences {
    private static int getCountOfOccurrences(int A, int B, int[] C){

        Map<Integer, Integer> freqMap  = new HashMap<>();
        //Iterate over array elements and build freq map
        for (int c: C){
            if (freqMap.containsKey(c)){
                freqMap.put(c, freqMap.get(c)+1);
            }else freqMap.put(c, 1);
        }

        int mod = (int) Math.pow(10,9)+7;
        int sum =0;
        boolean isModified = false; // handle case where sum of elements is zero
        // check frequency if that mataches to "B" and add the respective keys
        for (Map.Entry<Integer,Integer> mapEntry : freqMap.entrySet()){
            if (mapEntry.getValue() == B){
                sum = (sum + mapEntry.getKey())%mod;
                isModified =true;
            }
        }
        return (sum ==0 && isModified == false)? -1 : sum;
    }

    public static void main(String[] args) {
        int [] data = { 1,2,2,3,3};
        System.out.println(getCountOfOccurrences(5, 2, data)); // expected 5
    }
}
